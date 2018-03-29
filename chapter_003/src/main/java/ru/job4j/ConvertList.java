package ru.job4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 27.03.2018
 * @version 1
 */
public class ConvertList {
    /**
     * в метод приходит двумерный массив целых чисел, необходимо пройтись по всем элементам массива и добавить их в List<Integer>
     * @param array двумерный массив.
     * @return списаок.
     */
    public List<Integer> toList (int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**
     * метод toArray должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк -
     * оставшиеся значения в массиве заполнять нулями.
     * @param list список.
     * @param rows количество строк.
     * @return массив
     */
    public int[][] toArray (List<Integer> list, int rows) {
        int column = list.size() / rows;
        if (column % rows != 0) {
            column++;
        }
        int count = 0, number = 0, line = 0;
        int[][] result = new int[rows][column];
        for (int[] out : result) {
            for (int in : out) {
                if (count < list.size()) {
                    result[line][number++] = list.get(count++);
                }
            }
            line++;
            number = 0;
        }
        return result;
    }

    /**
     * Этот метод добавляет лист массивов в один лист Integer.
     * @param list лист массивов.
     * @return один лист Integer.
     */
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] out : list) {
            for (int in : out) {
                result.add(in);
            }
        }
        return result;
    }
}
