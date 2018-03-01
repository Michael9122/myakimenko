package ru.job4j.tracker;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 24.02.2018
 * @version 1
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
