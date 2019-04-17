package ru.job4j.xslt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 17.04.2019
 */
public class StoreSQL implements AutoCloseable {

    private final Config config;

    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Метод генерирует записи в БД, так же удаляет и создает БД.
     * @param size количество записей.
     * @throws Exception
     */
    public void generate(int size) throws Exception {
        try {
            config.init();
            connect = DriverManager.getConnection(config.get("url"));
            connect.setAutoCommit(false);
            Statement st = connect.createStatement();
            st.executeUpdate("drop table if exists entry");
            st.executeUpdate("create table if not exists entry (field integer)");
            for (int i = 1; i <= size; i++) {
                st.executeUpdate("insert into entry (field) values (" + i + ")");
            }
            connect.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connect.rollback();
        }
        close();
    }

    /**
     * Сохраняет записи из БД в массив.
     * @return массив записей.
     */
    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try {
            config.init();
            connect = DriverManager.getConnection(config.get("url"));
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("select * from entry");
            while (rs.next()) {
                result.add(new Entry(rs.getInt(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}