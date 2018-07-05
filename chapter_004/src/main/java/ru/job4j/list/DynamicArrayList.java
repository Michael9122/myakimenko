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

    private int modCount = 0;

    private int size = 0;

    public DynamicArrayList() {
        this.elementData = new Object[empty];
    }

    /**
     * Проверка заполнености массива.
     * @return true если массив заполнен не полностью, false если массив полностью заполен.
     */
    private void checkEmpty() {
        if (size == elementData.length) {
            modCount++;
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
    }

    /**
     * Добавление элемента в массив.
     * @param value элемент.
     */
    public void add(E value) {
        checkEmpty();
        elementData[size++] = value;
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

            int cursor;
            int lastRet = -1;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public E next() {
                checkForComodification();
                int i = cursor;
                if (i >= size) {
                    throw new NoSuchElementException();
                }
                Object[] elementData = DynamicArrayList.this.elementData;
                if (i >= elementData.length) {
                    throw new ConcurrentModificationException();
                }
                cursor = i + 1;
                lastRet = i;
                return (E) elementData[lastRet];
            }
            /**
             * Проверка на то, что с момента создания итератора коллекция не подверглась структурному изменению.
             */
            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
