package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {
    @Test
    public void whenFirstLessSecondThenSecond() {
        Max maxOne = new Max();
        int result = maxOne.max(1, 2);
        assertThat(result, is(2));
    }
}
