package ru.job4j.array;

/**
 * Класс для создания и заполнения массива.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.02.2018
 * @version 1
 */
public class Square {

    /**
     * Method paint.
     * @param bound натуральное число.
     * @return Массив.
     */
    public int[] calculate(int bound) {

        int[] rst = new int[bound];
        for (int i = 0; i != rst.length; i++) {
            rst[i] = (int) Math.pow((i + 1), 2);
        }
        return rst;
    }
}
