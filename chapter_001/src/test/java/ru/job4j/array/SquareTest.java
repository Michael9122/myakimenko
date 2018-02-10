package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.02.2018
 * @version 1
 */
public class SquareTest {

    /**
     * Тест класса.
     * Заполнение массива числами от 1 до 5, возведенными в квадрат.
     */
    @Test
    public void whenInputFiveThanResultArrayOfSquaresTillFive() {
        Square square = new Square();
        int[] expected = {1, 4, 9, 16, 25};
        int[] result = square.calculate(5);
        assertThat(result, is(expected));
    }
}


