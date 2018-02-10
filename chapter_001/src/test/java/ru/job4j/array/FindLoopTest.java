package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для поиска элемента в массиве.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.02.2018
 * @version 1
 */
public class FindLoopTest {

    /**
     * Тест класса.
     * Проверяет что элемент найден.
     */
    @Test
    public void whenFoundIndexThenReturnIndex() {
        FindLoop test = new FindLoop();
        int[] date = {1, 4, 9, 16, 25};
        int result = test.indexOf(date, 16);
        assertThat(result, is(3));
    }

    /**
     * Тест класса.
     * проверяет что элемент не найден.
     */
    @Test
    public void whenNotFoundIndexThenReturnMinusOne() {
        FindLoop test = new FindLoop();
        int[] date = {1, 4, 9, 16, 25};
        int result = test.indexOf(date, 2);
        assertThat(result, is(-1));
    }
}
