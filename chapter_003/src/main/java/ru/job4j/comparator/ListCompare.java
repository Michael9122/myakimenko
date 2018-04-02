package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает два массива и возвращает 1 если правый массив больше, -1 если левый массив больше, 0 если они равны.
     * @param left массив.
     * @param right массив.
     * @return 1, 0, -1.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            } else if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
