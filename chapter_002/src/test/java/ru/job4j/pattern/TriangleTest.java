package ru.job4j.pattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class TriangleTest {

    /**
     * Тест треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append("  +++  ")
                                .append(" +++++ ")
                                .append("+++++++")
                                .toString()
                )
        );
    }
}
