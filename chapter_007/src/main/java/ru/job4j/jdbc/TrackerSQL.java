package ru.job4j.jdbc;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 11.04.2019
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    public TrackerSQL() {
        init();
    }

    /**
     * Подключение к базе данных.
     */
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
            checkTable(this.connection.createStatement());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    /**
     * Добавление заявки.
     * @param item заявка.
     */
    @Override
    public Item add(Item item) {
        String sql = "insert into items (id, name, description, created, comments) values (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            statement.setString(1, item.generateId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getDesc());
            statement.setLong(4, item.getCreated());
            statement.setObject(5, item.getComments());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Изменение заявки.
     * @param id старой заявки.
     * @param item новая заявка.
     */
    @Override
    public void replace(String id, Item item) {
        String sql = "update items set name = ?, description = ?, created = ?, comments = ? where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setLong(3, item.getCreated());
            statement.setObject(4, item.getComments());
            statement.setString(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление заявки.
     * @param id заявки.
     */
    @Override
    public void delete(String id) {
        String sql = "delete from items where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Поиск всех заявок.
     */
    @Override
    public List<Item> findAll() {
        String sql = "select * from items";
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s, %s, %s, %s, %s",
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getLong("created"),
                        rs.getObject("comments")));
                Item item = new Item(rs.getString(2), rs.getString(3), rs.getLong(4));
                item.setId(rs.getString(1));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Поиск заявки по имени.
     * @param key имя заявки.
     */
    @Override
    public List<Item> findByName(String key) {
        String sql = "select * from items where name = ?";
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString(2), rs.getString(3), rs.getLong(4));
                item.setId(rs.getString(1));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Поиск заявки по id.
     * @param id заявки.
     */
    @Override
    public Item findById(String id) {
        String sql = "select * from items where id = ?";
        Item item = null;
        try (PreparedStatement statement = this.connection.prepareStatement(sql);) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString("name"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод создает таблицу, если такой таблицы еще нет.
     */
    private void checkTable(Statement st) {
        String sql = "create table if not exists items ("
                + "id varchar primary key, "
                + "name varchar,"
                + "description varchar,"
                + "created double precision,"
                + "comments text"
                + ");";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
