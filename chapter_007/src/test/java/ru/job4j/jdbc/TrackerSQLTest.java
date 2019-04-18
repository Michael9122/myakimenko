package ru.job4j.jdbc;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").get(0).getName(), is("name"));
        }
    }

    @Test
    public void whenAddNewItemThenAdd() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("add", "desc", 123L);
            tracker.add(item);
            assertThat(item.getName(), is("add"));
        }
    }

    @Test
    public void whenFindByIdThenReturnItemId() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("findById", "desc", 123L);
            tracker.add(item);
            assertThat(tracker.findById(item.getId()), is(item.getId()));
        }
    }

    @Test
    public void whenReplaceThenNewName() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("item", "desc", 123L);
            Item itemReplace = new Item("new Name", "desc", 123L);
            tracker.add(item);
            tracker.replace(tracker.findByName("item").get(0).getId(), itemReplace);
            assertThat(tracker.findByName("new Name").get(0).getName(), Is.is("new Name"));
        }
    }

    @Test
    public void whenFindByNameThenReturnName() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("findByName", "desc", 123L);
            tracker.add(item);
            assertThat(tracker.findByName(item.getName()).get(0).getName(), is("findByName"));
        }
    }

    @Test
    public void whenDeleteItemThenDelete() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("delete", "desc", 123L);
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findById(item.getId()), is(nullValue()));
        }
    }

    @Test
    public void whenFindAllThenReturnAll() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("findAll", "desc", 123L);
            tracker.add(item);
            tracker.findAll();
        }
    }
}