package ru.job4j.array;

/**
 * Класс для создания таблицы умножения.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class Matrix {

    /**
     * Таблица умножения.
     * @param size размер будующей матрицы.
     * @return Массив.
     */
    public int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                array[i - 1][j - 1] = i * j;
            }
        }
        return array;
    }
}
