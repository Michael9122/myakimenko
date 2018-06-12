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

    private int expectedModCount;

    /**
     * Конструктор класса.
     */
    public ContainerLinkedList() {
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

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int count = 0;

            E date;

            public boolean hasNext() {
                return (count < size) && (last != null);
            }

            public E next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                count++;
                date = first.item;
                first = first.next;
                return date;
            }
        };
    }

    /**
     * Проверка на то, что с момента создания итератора коллекция не подверглась структурному изменению.
     */
    private final void checkForComodification() {
        expectedModCount = modCount;
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
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
