package ru.job4j.set;

import ru.job4j.list.DynamicArrayList;

import java.util.Iterator;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.07.2018
 * @version 1
 */
public class SimpleSet<E> implements Iterable<E> {

    DynamicArrayList<E> list = new DynamicArrayList<>();

    /**
     * Метод проверяет совпадение элементов.
     * @param e элемент.
     * @return true если такой элемент уже есть, либо false если нет.
     */
    public boolean contains(E e) {
        boolean result = false;
        for (E element : list) {
            if (element.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод проверяет совпадают ли элементы и если нет, то добавляет его.
     * @param e элемент.
     */
    public void add(E e) {
        if (!contains(e)) {
            list.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
