package ru.job4j.test;

public class Entry {

    public static void main(String[] args) {
        Logic logic = new Logic(new ConsoleInputOutput(), new ShowMenu(), 3, 3);
        logic.go();
    }
}
