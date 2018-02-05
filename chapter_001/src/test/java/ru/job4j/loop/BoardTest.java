package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.02.2018
 * @version 1
 */
public class BoardTest {

    /**
     * Тест класса.
     * при вызове метода с параметрами 3, 3
     * должно вернуться доска размерами 3 на 3
     * ("X X%s X %sX X%s", line, line, line).
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X%s X %sX X%s", line, line, line);
        assertThat(result, is(expected));
    }

    /**
     * Тест класса.
     * при вызове метода с параметрами 5, 4
     * должна вернуться доска размерами 5 на 4
     * ("X X X%s X X %sX X X%s X X %s", line, line, line, line, line).
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        //напишите здесь тест, проверяющий формирование доски 5 на 4.
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s", line, line, line, line, line);
        assertThat(result, is(expected));
    }
}