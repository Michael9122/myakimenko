package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.07.2018
 * @version 1
 */
public class SimpleSetTest {

    private SimpleSet<Integer> set;

    @Before
    public void setUp() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void whenAddElementThenContainsTrue() {
        set.add(4);
        assertThat(set.contains(4), is(true));
    }
}