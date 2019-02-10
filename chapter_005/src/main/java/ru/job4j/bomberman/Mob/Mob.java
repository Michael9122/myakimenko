package ru.job4j.bomberman.Mob;

import ru.job4j.bomberman.Cell;

public abstract class Mob implements Runnable{

    final Cell position;

    public Cell getPosition() {
        return position;
    }

    protected Mob(Cell position) {
        this.position = position;
    }
}
