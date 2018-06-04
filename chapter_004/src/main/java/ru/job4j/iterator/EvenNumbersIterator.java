package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.06.2018
 * @version 1
 */
public class EvenNumbersIterator implements Iterator {

    private int[] value;
    private int i = 0;

    public EvenNumbersIterator(int[] value) {
        this.value = value;
    }

    /**
     * Возвращает true, только если в массиве есть четные перед указателем.
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int index = i; index < value.length; index++) {
            if (value[index] % 2 == 0) {
                i = index;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращают только четные числа.
     * @return четное число в массиве.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[i++];
    }
}
