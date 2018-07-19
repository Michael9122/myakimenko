package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.07.2018
 * @version 1
 */
public class HashMapTest {

    HashMap<Integer, String> map = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        map.insert(1, "Michael");
        map.insert(2, "Alexandr");
    }

    @Test
    public void whenGetThenReturnValue() {
        assertThat(map.get(1), is("Michael"));
    }

    @Test
    public void whenDeleteThenReturnTrue() {
        map.insert(3, "Ivan");
        assertThat(map.delete(3), is(true));
    }

    @Test
    public void shouldReturnPrimeNumbersOnly() {
        Iterator<HashMap.Entry<Integer, String>> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("Michael"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().value, is("Alexandr"));

    }
}