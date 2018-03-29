package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ConvertListTest {
    @Test
    public void whenToListAddArrayThenArrayList() {
        ConvertList convert = new ConvertList();
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(convert.toList(array), is(expected));
    }

    @Test
    public void whenToArrayThenArray() {
        ConvertList convert = new ConvertList();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expected = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(convert.toArray(list, 3), is(expected));
    }

    @Test
    public void whenToListArrayThenReturnList() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(convertList.convert(list), is(expected));
    }
}
