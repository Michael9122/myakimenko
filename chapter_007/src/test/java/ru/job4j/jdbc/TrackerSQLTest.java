package ru.job4j.jdbc;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    TrackerSQL tracker = new TrackerSQL();

    @Test
    public void checkConnection() {
        assertThat(tracker.init(), is(true));
    }

    @Test
    public void whenAddNewItemThenAdd() {
        Item item = new Item("add", "desc", 123L);
        tracker.add(item);
        assertThat(item.getName(), is("add"));
    }

    @Test
    public void whenFindByIdThenReturnItemId() {
        Item item = new Item("findById", "desc", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item.getId()));
    }

    @Test
    public void whenReplaceThenNewName() {
        Item item = new Item("item", "desc", 123L);
        Item itemReplace = new Item("new Name", "desc", 123L);
        tracker.add(item);
        tracker.replace(tracker.findByName("item").get(0).getId(), itemReplace);
        assertThat(tracker.findByName("new Name").get(0).getName(), Is.is("new Name"));
    }

    @Test
    public void whenFindByNameThenReturnName() {
        Item item = new Item("findByName", "desc", 123L);
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("findByName"));
    }

    @Test
    public void whenDeleteItemThenDelete() {
        Item item = new Item("delete", "desc", 123L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllThenReturnAll() {
        Item item = new Item("findAll", "desc", 123L);
        tracker.add(item);
        tracker.findAll();

    }
}