package ru.job4j.list;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.06.2018
 * @version 1
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Добавление жлемента в список.
     * @param date элемент.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Удаление элемента из списка.
     * @return список.
     */
    public E delete() {
        Node<E> result = this.first;
        first = first.next;
        size--;
        return result.date;
    }

    /**
     * Получение элемента по индексу.
     * @param index элемента.
     * @return элемент.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Получить размер списка.
     * @return размер списка.
     */
    public int getSize() {
        return this.size;
    }

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}

