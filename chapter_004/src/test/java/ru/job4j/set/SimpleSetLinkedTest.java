package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetLinkedTest {

    SimpleSetLinked<Integer> list = new SimpleSetLinked<>();

    @Before
    public void setUp() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenAddSameElementThenContainsTrue() {
        list.add(1);
        assertThat(list.contains(1), is(true));
    }
}