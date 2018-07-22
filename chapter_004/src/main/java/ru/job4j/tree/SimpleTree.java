package ru.job4j.tree;

import java.util.Optional;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 22.07.2018
 * @version 1
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
