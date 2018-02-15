package ru.job4j.array;

/**
 * Class Класс для поиска одного слова в другом.
 * @author Michael Yakimenko
 * @since 13.02.2018
 * @version 1
 */
public class TestTaskOne {

    /**
     * Method contains.
     * @param origin Your name.
     * @param sub Your name.
     * @return true или false.
     */
    boolean contains(String origin, String sub) {
        char[] word = origin.toCharArray();
        char[] wordInWord = sub.toCharArray();
        boolean result = false;
        int count = 0;
        for (int i = 0; i != word.length; i++) {
            for (int j = 0; j  != wordInWord.length; j++) {
                if (wordInWord[j] == word[i]) {
                    i++;
                    count ++;
                    if (count == wordInWord.length) {
                        result = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return result;
    }
}