package ru.job4j.test;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput {

    private Scanner reader = new Scanner(System.in);

    @Override
    public int question(String question) {
        System.out.println(question);
        boolean invalid = true;
        int in = -1;
        do {
            try {
                in = Integer.parseInt(reader.nextLine());
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
        } while (invalid);
        return in;
    }
}
