package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.02.2018
 * @version 1
 */
public class FactorialTest {

    /**
     * Тест класса.
     * вычисление факториала числа 5
     * должно вернутся 120.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial test = new Factorial();
        int result = test.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Тест класса.
     * вычисление факториала числа 0
     * должно вернутся 1.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial test = new Factorial();
        int result = test.calc(0);
        assertThat(result, is(1));
    }
}