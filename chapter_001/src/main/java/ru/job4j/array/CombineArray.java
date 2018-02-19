package ru.job4j.array;

/**
 * Класс для слияния двух массиово.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.02.2018
 * @version 1
 */
public class CombineArray {

    /**
     * Слияние.
     * @param arrayOne первый массив.
     * @param arrayTwo второй массив.
     * @return Массив.
     */
    public int[] combine(int[] arrayOne, int[] arrayTwo) {
        int[] arrayThree = new int[arrayOne.length + arrayTwo.length];
        int indexOne = 0, indexTwo = 0;
        for (int i = 0; i < arrayThree.length; i++) {
            if (indexTwo < arrayTwo.length && indexOne < arrayOne.length) {
                if (arrayOne[indexOne] > arrayTwo[indexTwo]) {
                    arrayThree[i] = arrayTwo[indexTwo++];
                } else {
                    arrayThree[i] = arrayOne[indexOne++];
                }
            } else if (indexTwo < arrayTwo.length) {
                arrayThree[i] = arrayTwo[indexTwo++];
            } else {
                arrayThree[i] = arrayOne[indexOne++];
            }
        }
        return arrayThree;
    }
}
