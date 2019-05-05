package ru.job4j.srp;

import java.util.Scanner;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 30.04.2019
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] size) throws MenuOutException {
        int key = Integer.valueOf(ask(question));
        boolean exist = false;
        for (int value : size) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
