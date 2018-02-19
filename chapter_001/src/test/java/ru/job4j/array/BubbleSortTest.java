package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class BubbleSortTest {

    /**
     * Тест класса.
     * Проверяет сортировку массива методом перестановки.
     */
    @Test
    public void sortArray() {
        BubbleSort test = new BubbleSort();
        int[] resultArray = {5, 1, 2, 7, 3};
        int[] expectArray = {1, 2, 3, 5, 7};
        int[] result = test.sort(resultArray);
        assertThat(result, is(expectArray));
    }
}
