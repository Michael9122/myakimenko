package ru.job4j.array;

/**
 * Класс для сортировки массива методом перестановки.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class BubbleSort {

    /**
     * Сортирует массив методом перестановки.
     * @param array массив.
     * @return Массив.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array;
    }
}
