package ru.job4j.pattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class SquareTest {

    /**
     * Тест квадрата.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("++++")
                                .append("++++")
                                .append("++++")
                                .toString()
                )
        );
    }
}
