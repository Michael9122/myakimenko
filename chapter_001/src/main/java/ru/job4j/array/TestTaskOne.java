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
        for (int i = 0; i < word.length - 1; i++) {
            for (int j = 0; j < wordInWord.length - 1; j++) {
                if (wordInWord[j] == word[i + j]) {
                    result = true;
                }
            }
        }
        return result;
    }
}