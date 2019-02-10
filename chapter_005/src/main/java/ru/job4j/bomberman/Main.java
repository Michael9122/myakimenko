package ru.job4j.bomberman;

import ru.job4j.bomberman.mobs.Mob;
import ru.job4j.bomberman.mobs.User;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Mob user = new User(new Cell(2, 2), board);
        Thread thread = new Thread(user);
        thread.start();
    }
}
