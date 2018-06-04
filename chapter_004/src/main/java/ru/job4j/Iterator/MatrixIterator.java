package ru.job4j.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 04.06.2018
 * @version 1
 */
public class MatrixIterator implements Iterator {

    private final int[][] value;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(final int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (j < value.length - 1) {
            result = true;
        } else if (j == value.length - 1) {
            if (i <= value[value.length - 1].length - 1) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (i < value[j].length) {
            return value[j][i++];
        } else {
            i = 0;
            return value[++j][i++];
        }
    }
}
