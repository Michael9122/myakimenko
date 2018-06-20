package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 20.06.2018
 * @version 1
 */
public class NodeTest {

    private static Cycles list = new Cycles();
    private static Node<Integer> one;
    private static Node<Integer> two;
    private static Node<Integer> third;
    private static Node<Integer> four;

    @Before
    public void setUp() {
        one = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    @Test
    public void whenCreateCycleListThenTrue() {
        one.next = two;
        two.next = third;
        third.next = four;
        four.next = one;
        assertThat(list.hasCycle(one), is(true));
        }

    @Test
    public void whenNextNodeNullThenReturnFalse() {
        one.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(list.hasCycle(one), is(false));
        }
}