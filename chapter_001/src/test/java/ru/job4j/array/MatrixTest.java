package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class MatrixTest {

    /**
     * Тест класса.
     * Проверяет класс для создания таблицы умножения размероми 2 на 2.
     */
    @Test
    public void whenSizeTwoThenMatrixTwoByTwo() {
        Matrix test = new Matrix();
        int[][] expected = {{1, 2}, {2, 4}};
        int[][] result = test.multiple(2);
        assertThat(result, is(expected));
    }

    /**
     * Тест класса.
     * Проверяет класс для создания таблицы умножения размероми 4 на 4.
     */
    @Test
    public void whenSizeFourThenMatrixFourByFour() {
        Matrix test = new Matrix();
        int[][] expected = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        int[][] result = test.multiple(4);
        assertThat(result, is(expected));
    }
}
