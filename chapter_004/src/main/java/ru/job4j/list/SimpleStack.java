package ru.job4j.list;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 17.06.2018
 * @version 1
 */
public class SimpleStack<T> {

    ContainerLinkedList<T> list = new ContainerLinkedList<T>();

    /**
     * Удаление из очереди.
     */
    public T poll() {
        return list.pollLast();
    }

    /**
     * Добавление в очередь.
     * @param value значение.
     */
    public void push(T value) {
        list.add(value);
    }
}
