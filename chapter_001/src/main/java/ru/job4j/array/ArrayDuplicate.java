package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для удаление дубликатов в массиве.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class ArrayDuplicate {

    /**
     * удаление дубликатов.
     * @param array массив.
     * @return Массив.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
