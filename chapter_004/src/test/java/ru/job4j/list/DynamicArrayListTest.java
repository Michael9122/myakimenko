package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.06.2018
 * @version 1
 */
public class DynamicArrayListTest {

    private DynamicArrayList<Integer> list = new DynamicArrayList<>();


    @Before
    public void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenAddElementThenGetThisElement() {
        list.add(5);
        assertThat(list.get(4), is(5));
    }

    @Test
    public void whenGetElementThenGetThisElement() {
        assertThat(list.get(2), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}