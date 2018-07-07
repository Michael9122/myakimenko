package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 12.06.2018
 * @version 1
 */
public class ContainerLinkedList<E> implements Iterable<E> {

    /**
     * Размер списка.
     */
    private int size = 0;

    /**
     * Указатель на первый элемент.
     */
    private Node<E> first;

    /**
     * Указатель на последний элемент.
     */
    private Node<E> last;

    private int modCount = 0;

    /**
     * Убирает первый элемент листа.
     * @param f первый элемент листа.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    /**
     * Убирает последний элемент листа.
     * @param l последний элемент листа.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    /**
     * Добавление элемента в списаок.
     * @param item элемент которуй нужно добавить.
     */
    public void add(E item) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Получение элемента по индексу.
     * @param index индекс элемента.
     * @return возвращает элемент.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    /**
     * Удаляет и возвращает первый элемент из листа.
     * @return первый элемент листа.
     */
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    /**
     * Удаляет и возвращает последний элемент из листа.
     * @return последний элемент листа.
     */
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int expectedModCount = modCount;
            private Node<E> current = first;
            private Node<E> lastReturned;
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = current;
                current = current.next;
                nextIndex++;
                return lastReturned.item;
            }
            /**
             * Проверка на то, что с момента создания итератора коллекция не подверглась структурному изменению.
             */
            private final void checkForComodification() {

                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
