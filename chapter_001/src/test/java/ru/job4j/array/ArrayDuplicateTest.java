package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 11.02.2018
 * @version 1
 */
public class ArrayDuplicateTest {

    /**
     * Тест класса.
     * Проверяет удаление дубликатов.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate test = new  ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] except = {"Привет", "Мир", "Супер"};
        String[] result = test.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}