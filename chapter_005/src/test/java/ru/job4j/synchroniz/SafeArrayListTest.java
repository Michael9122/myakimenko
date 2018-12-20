package ru.job4j.synchroniz;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 20.12.2018
 * @version 1
 */
public class SafeArrayListTest {

    private SafeArrayList<String> list = new SafeArrayList();

    @Before
    public void setUp() throws Exception {
        list.add("one");
        list.add("two");
    }

    @Test
    public void add() {
        list.add("three");
        assertThat(list.get(2), is("three"));
    }

    @Test
    public void get() {
        assertThat(list.get(1), is("two"));
    }

    @Test
    public void iterator() {
        list.iterator();
        assertThat(list.iterator().next(), is("one"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        Iterator<String> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}