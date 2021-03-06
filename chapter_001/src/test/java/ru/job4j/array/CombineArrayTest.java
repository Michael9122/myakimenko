package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.02.2018
 * @version 1
 */
public class CombineArrayTest {

    /**
     * Тест класса.
     * Проверяет слияние массивов.
     */
    @Test
    public void whenCombineTwoArraysThenCreateAnotherArray() {
        CombineArray test = new CombineArray();
        int[] arrayOne = {1, 3, 4, 6, 21};
        int[] arrayTwo = {2, 5, 7, 8};
        int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 21};
        int[] result = test.combine(arrayOne, arrayTwo);
        assertThat(result, is(expectArray));
    }

    /**
     * Тест класса.
     * Проверяет слияние массивов.
     */
    @Test
    public void whenCombineTwoArraysThenCreateAnotherArray2() {
        CombineArray test = new CombineArray();
        int[] arrayOne = {2, 21, 34, 56};
        int[] arrayTwo = {7, 43, 54, 120};
        int[] expectArray = {2, 7, 21, 34, 43, 54, 56, 120};
        int[] result = test.combine(arrayOne, arrayTwo);
        assertThat(result, is(expectArray));
    }

}
