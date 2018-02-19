package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko
 * @since 13.02.2018
 * @version 1
 */
public class TestTaskOneTest {

    /**
     * Test contains.
     * Проверяет что одно слово находится в другом.
     */
    @Test
    public void whenFoundWordThenTrue() {
        TestTaskOne test = new TestTaskOne();
        boolean result = test.contains("Привет", "иве");
        assertThat(result, is(true));
    }

    /**
     * Test contains.
     * Проверяет что одно слово находится в другом.
     */
    @Test
    public void whenDoNotFoundWordThenFalse() {
        TestTaskOne test = new TestTaskOne();
        boolean result = test.contains("Привет", "Абв");
        assertThat(result, is(false));
    }
}
