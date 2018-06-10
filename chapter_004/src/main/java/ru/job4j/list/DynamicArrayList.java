package ru.job4j.list;

import java.util.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.06.2018
 * @version 1
 */
public class DynamicArrayList<E> implements Iterable<E> {

    private Object[] elementData;

    private int empty = 10;

    private int index = 0;

    private int modCount = 0;

    public DynamicArrayList() {
        this.elementData = new Object[empty];
    }

    /**
     * Проверка заполнености массива.
     * @return true если массив заполнен не полностью, false если массив полностью заполен.
     */
    private boolean checkEnpty() {
        return (elementData.length - 1 == index && elementData.length >= empty) ? true : false;
    }

    /**
     * Добавление элемента в массив.
     * @param value элемент.
     */
    public void add(E value) {
        modCount++;
        boolean result = checkEnpty();
        if (result) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[index++] = value;

    }

    /**
     * Получение элемента.
     * @param index элемента.
     * @return элемент.
     */
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != elementData.length;
            }

            @Override
            public E next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (cursor >= elementData.length) {
                    throw new ConcurrentModificationException();
                }
                return (E) elementData[cursor++];
            }
        };
    }

    /**
     * Проверка на то, что с момента создания итератора коллекция не подверглась структурному изменению.
     */
    final void checkForComodification() {
        int expectedModCount = modCount;
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
