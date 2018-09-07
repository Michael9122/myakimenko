package ru.job4j.test;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
public class StoreTest {

    List<Store.User> current = new ArrayList<>();
    List<Store.User> previous = new ArrayList<>();
    Store store = new Store();

    @Before
    public void setUp() {
        previous.add(new Store.User(1, "Michael"));
        previous.add(new Store.User(2, "Ivan"));
        previous.add(new Store.User(3, "Alexandr"));
        current.addAll(previous);
    }

    @Test
    public void replace() {
        current.set(1, new Store.User(2, "Igvar"));
        current.set(0, new Store.User(1, "Alex"));
        Info info = store.diff(previous, current);
        System.out.println(info);
        assertThat(info.getReplace(), is(2));

    }

    @Test
    public void delete() {
        current.remove(0);
        current.remove(1);
        Info info = store.diff(previous, current);
        System.out.println(info);
        assertThat(info.getDelete(), is(2));
    }

    @Test
    public void insert() {
        current.add(new Store.User(4, "Nikola"));
        current.add(new Store.User(5, "Luba"));
        current.add(new Store.User(6, "Valera"));
        Info info = store.diff(previous, current);
        System.out.println(info);
        assertThat(info.getInsert(), is(3));
    }
}