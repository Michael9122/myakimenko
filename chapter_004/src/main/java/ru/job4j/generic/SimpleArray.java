package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 08.06.2018
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {

    /**
     * Массив.
     */
    private Object[] objects;
    /**
     * Индекс элемента.
     */
    private int index = 0;

    /**
     * Конструктор.
     * @param size размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int current = 0;

            /**
             * Возвращает true если в массиве есть элементы либо, false если нету.
             * @return true or false.
             */
            @Override
            public boolean hasNext() {
                return current < objects.length;
            }

            /**
             * Возвращает текущий элемент итерации и переходит к следующему.
             * @return элемент.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[current++];
            }
        };
    }

    /**
     * Добавляет элемент в массив.
     * @param model элемент.
     */
    public void add(T model) {
        this.objects[index++] = model;
    }

    /**
     * Добавляет элемент в массив по индексу.
     * @param index позиция.
     * @param model элемент.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * Удаляет элемент в массиве по индексу.
     * @param index позиция элемента.
     */
    public void delete(int index) {
        this.objects[index] = null;
    }

    /**
     * Получает элемент по индексу
     * @param index позиция элемента.
     * @return элемент.
     */
    public T get(int index) {
        return (T) this.objects[index];
    }
}
