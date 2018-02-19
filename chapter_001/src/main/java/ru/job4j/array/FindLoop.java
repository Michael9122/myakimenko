package ru.job4j.array;

/**
 * Класс для поиска элемента в массиве.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.02.2018
 * @version 1
 */
public class FindLoop {

    /**
     * Поиск элемента.
     * @param data массив.
     * @param el индекс элемента массива.
     * @return Массив.
     */
    public int indexOf(int[] data, int el) {
        int rsl = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
