package ru.job4j.bomberman;

import ru.job4j.bomberman.Mob.Mob;
import ru.job4j.bomberman.Mob.User;

public class Logic {

    public static void main(String[] args) {
        Board board = new Board();
        Mob user = new User(new Cell(2, 2), board);
        Thread thread = new Thread(user);
        thread.start();
    }
}