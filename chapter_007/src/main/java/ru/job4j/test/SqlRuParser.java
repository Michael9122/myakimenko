package ru.job4j.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.quartz.*;

import ru.job4j.jdbc.TrackerSQL;

import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 29.04.2019
 */
public class SqlRuParser implements AutoCloseable, Job {

    private Logger log = LogManager.getLogger(SqlRuParser.class);

    private List<Article> articleList = new ArrayList<>();

    private Connection connection;

    private final Map<String, String> map = new LinkedHashMap<>();

    private final SimpleDateFormat format = new SimpleDateFormat("dd MMM yy");

    private final Date lastDate = format.parse("01 January 19");

    public SqlRuParser() throws ParseException {
        init();
    }

    private boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Метод получет все элементы "tr" из "body" затем проходится по ним и получает наименовение вакансии,
     * если оно содержит "Java" то получает его дату, и ссылку.
     * По ссылки коннектится и получает описание вакансии.
     * Если дата создания ваканси после 19 года поиск останавливается.
     */
    public void parse() throws Exception {
        boolean search = true;
        int page = 1;
        while (search) {
            Document document = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + page).get();
            Elements trElements = document.body().attr("table", "forumTable").select("tr");
            for (Element trElement : trElements) {
                String title = trElement.attr("td", "postslisttopic").select("a").text().split("\\[")[0];
                if (title.toLowerCase().contains("java") && !title.toLowerCase().contains("java script") && !title.toLowerCase().contains("javascript")) {
                    String date = trElement.select("td.altCol").last().text();
                    String url = trElement.attr("td", "postslisttopic").select("a").attr("href");
                    Document doc = Jsoup.connect(url).get();
                    Element element = doc.getElementsByAttributeValue("class", "msgBody").get(1);
                    String text = lineBreak(element.html());
                    if (!dateConverter(date)) {
                        search = false;
                        break;
                    }
                    articleList.add(new Article(title, url, text));
                    articleList.forEach(article -> add(article));
                }
            }
            articleList.forEach(System.out::println);
            page++;
        }
    }

    /**
     * Метод для переноса сток.
     * Если исходный html содержит новую строку (\n), он сохраняется,
     * Если исходный html содержит br или p-теги, они переводятся в новую строку (\n).
     */
    private static String lineBreak(String html) {
        if (html == null) {
            return html;
        }
        Document document = Jsoup.parse(html);
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));
        document.select("br").append("\\n");
        document.select("p").prepend("\\n\\n");
        String s = document.html().replaceAll("\\\\n", "\n");
        return Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
    }

    /**
     * Метод для преобразования String в Date.
     *
     * @param date дата.
     * @return дату в формате Date.
     */
    private boolean dateConverter(String date) throws ParseException {
        map.put("янв", "January");
        map.put("фев", "February");
        map.put("мар", "March");
        map.put("апр", "April");
        map.put("май", "May");
        map.put("июн", "June");
        map.put("июл", "July");
        map.put("авг", "August");
        map.put("сен", "September");
        map.put("окт", "October");
        map.put("ноя", "November");
        map.put("дек", "December");

        boolean booleanResult = false;
        Date result = null;
        LocalDate localDate = LocalDate.now();
        if (date.contains("вчера")) {
            LocalDate yesterday = localDate.minusDays(1);
            Date yesterdayDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
            result = yesterdayDate;
        } else if (date.contains("сегодня")) {
            Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            result = today;
        } else {
            String sep = date.split(" ")[1];
            String newDate = date.replace(sep, map.get(sep));
            Date dateOne = format.parse(newDate);
            result = dateOne;
        }
        if (result.after(lastDate)) {
            booleanResult = true;
        }
        return booleanResult;
    }

    /**
     * Проверяет совпадение по вакансиям в БД и на сайте.
     */
    private boolean checkCopy(Statement st, String title) {
        boolean result = true;
        try (ResultSet rs = st.executeQuery("select v.name from vacancy as v")) {
            while (rs.next()) {
                String name = rs.getString("name");
                if (name.equals(title)) {
                    result = false;
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Проверяет создана ли БД, если нет, то создает её и добавляет новую вакансию.
     *
     * @param article Вакансия.
     */
    private void add(Article article) {
        try {
            createTable(this.connection.createStatement());
            if (checkCopy(this.connection.createStatement(), article.getName())) {
                try (PreparedStatement st = this.connection.prepareStatement("insert into vacancy (name, text, link) values (?, ?, ?)")) {
                    st.setString(1, article.getName());
                    st.setString(2, article.getText());
                    st.setString(3, article.getUrl());
                    st.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Запрос для создания БД.
     */
    private void createTable(Statement st) {
        String sql = "create table if not exists vacancy ("
                + "id serial primary key, "
                + "name varchar,"
                + "text text,"
                + "link varchar"
                + ");";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            parse();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Класс для описания заявки.
     */
    class Article {
        private String name;
        private String url;
        private String text;

        public Article(String name, String url, String text) {
            this.name = name;
            this.url = url;
            this.text = text;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("%s | %s\n%s\n", name, url, text);
        }
    }
}
