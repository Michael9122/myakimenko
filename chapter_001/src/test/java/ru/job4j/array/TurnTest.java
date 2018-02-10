package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Класс для создания шахматной доски в псевдографике.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.02.2018
 * @version 1
 */
public class TurnTest {

    /**
     * Тест класса.
     * Для нечетного количества элементов в массиве.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn test = new Turn();
        int[] numbers = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = test.back(numbers);
        assertThat(result, is(expected));
    }

    /**
     * Тест класса.
     * Для четного количества элементов в массиве.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn test = new Turn();
        int[] numbers = {4, 1, 6, 2};
        int[] expected = {2, 6, 1, 4};
        int[] result = test.back(numbers);
        assertThat(result, is(expected));
    }
}
