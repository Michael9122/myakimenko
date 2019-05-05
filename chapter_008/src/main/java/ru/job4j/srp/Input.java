package ru.job4j.srp;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 01.05.2019
 */
public interface Input {

    /**
     * Say question and read answer.
     * @param question question to be asked.
     * @return return the answer in the format double.
     */
    String ask(String question);

    int ask(String question, int[] size)throws MenuOutException;
}
