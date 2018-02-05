package ru.job4j.max;

public class Max {

    public static int max(int first, int second) {
        return first > second ? first : second;
    }
    public int maxThird(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
