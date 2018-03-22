package ru.job4j;

import java.util.Arrays;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.03.2018
 * @version 1
 */
public class CoffeeMachine {
    private final int[] currency = {10, 5, 2, 1};
    /**
     * Метод должен вернуть здачу.
     * @param value купюра.
     * @param price цена кофе.
     * @return массив здачи.
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] result = new int[1];
        while (change != 0) {
            for (int i = currency.length - 1; i >= 0; i--) {
                result = currency;
                change = change - i;
                if (i >= result.length - 1) {
                    result = Arrays.copyOf(result, result.length);
                }
            }
            if (change == 0) {
                break;
            }
        }
        return result;
    }
}
