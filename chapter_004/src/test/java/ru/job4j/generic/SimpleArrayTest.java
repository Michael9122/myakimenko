package ru.job4j.generic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 08.06.2018
 * @version 1
 */
public class SimpleArrayTest {

    SimpleArray<Integer> array = new SimpleArray<>(5);


    @Before
    public void setUp() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
    }

    @Test
    public void shouldGetValue() {
        Integer result = array.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void shouldSetValue() {
        array.set(4, 5);
        assertThat(array.get(4), is(5));
    }

    @Test
    public void shouldDeleteValue() {
        array.delete(0);
        assertThat(array.get(0), is(nullValue()));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator it = array.iterator();
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(2));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(5));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator it = array.iterator();
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.next(), Matchers.is(2));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.next(), Matchers.is(5));
    }
}