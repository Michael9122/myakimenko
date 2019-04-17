package ru.job4j.jdbc;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    @Test
    public void whenAddNewItemThenAdd() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("add", "desc", 123L);
        tracker.add(item);
        assertThat(item.getName(), is("add"));
        tracker.close();
    }

    @Test
    public void whenFindByIdThenReturnItemId() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("findById", "desc", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item.getId()));
        tracker.close();
    }

    @Test
    public void whenReplaceThenNewName() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("item", "desc", 123L);
        Item itemReplace = new Item("new Name", "desc", 123L);
        tracker.add(item);
        tracker.replace(tracker.findByName("item").get(0).getId(), itemReplace);
        assertThat(tracker.findByName("new Name").get(0).getName(), Is.is("new Name"));
        tracker.close();
    }

    @Test
    public void whenFindByNameThenReturnName() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("findByName", "desc", 123L);
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("findByName"));
        tracker.close();
    }

    @Test
    public void whenDeleteItemThenDelete() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("delete", "desc", 123L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
        tracker.close();
    }

    @Test
    public void whenFindAllThenReturnAll() throws Exception {
        TrackerSQL tracker = new TrackerSQL();
        Item item = new Item("findAll", "desc", 123L);
        tracker.add(item);
        tracker.findAll();
        tracker.close();
    }
}