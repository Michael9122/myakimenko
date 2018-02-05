package ru.job4j.loop;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.02.2018
 * @version 1
 */
public class Factorial {

    /**
     * Method calc.
     * @param n натуральное число.
     * @return факториал числа.
     */
    public int calc(int n) {
        int a = 1;
        for (int i = 1; i <= n; i++) {
        a *= i;
            System.out.println(a);
        }
        return a;
    }
}
