package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 01.06.2018
 * @version 1
 */
public class DepartmentSortTest {

    /**
     * Массив исходных департаментов.
     */
    private List<String> departments = new ArrayList<>(Arrays.asList(
            "K2\\SK1\\SSK2",
            "K2\\SK1\\SSK1",
            "K2",
            "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1",
            "K1\\SK2",
            "K1\\SK1"));

    /**
     * Сортировка по возрастанию.
     */
    @Test
    public void whenStringArrayIsSortedAscending() {
        DepartmentSort sortDepartments = new DepartmentSort();
        List<String> result = sortDepartments.sortAscending(departments);
        List<String> expected = Arrays.asList(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2");
        assertThat(result, is(expected));

    }

    /**
     * Сортировка по убыванию.
     */
    @Test
    public void whenStringArrayIsSortedDecreasing() {
        DepartmentSort sortDepartments = new DepartmentSort();
        List<String> result = sortDepartments.sortDescending(departments);
        List<String> expected = Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1");
        assertThat(result, is(expected));
    }
}
