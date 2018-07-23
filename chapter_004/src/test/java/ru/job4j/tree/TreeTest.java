package ru.job4j.tree;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 22.07.2018
 * @version 1
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenBinaryTreeThenTrue() {
        Tree<Integer> tree = new Tree<>();
        tree.add(8, 4);
        tree.add(8, 12);
        tree.add(4, 2);
        tree.add(4, 6);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenTreeIsNotBinaryThenFalse() {
        Tree<Integer> tree = new Tree<>();
        tree.add(8, 4);
        tree.add(8, 12);
        tree.add(4, 2);
        tree.add(4, 6);
        tree.add(4, 5);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void iterator() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(4));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(5));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(6));
    }
}