package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 06.06.2018
 * @version 1
 */
public class PrimeIterator implements Iterator {

    private int[] value;
    private int index = 0;

    public PrimeIterator(int[] value) {
        this.value = value;
    }

    /**
     * Проверяет является ли число простым.
     * @param number число из массива.
     * @return true or false.
     */
    public boolean isPrime(int number) {
        boolean prime = false;
        for (int i = 2; i <= number; i++) {
                if (i > Math.sqrt(number)) {
                    prime = true;
                    break;
                }
                if (number % 2 == 0) {
                    prime = false;
                    break;
                }
        }
        return prime;
    }

    /**
     * Возвращает true если в массиве есть простые числа перед указателем.
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index != value.length) {
            if (isPrime(value[index])) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /***
     * Возвращает простое число.
     * @return просточе число.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[index++];
    }
}
