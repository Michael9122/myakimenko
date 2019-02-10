package ru.job4j.bomberman;

import ru.job4j.bomberman.exceptions.BombermanException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board {

    private final ReentrantLock[][] board = new ReentrantLock[50][50];

    /**
     * @param source исходная позиция.
     * @param dest место назначения.
     * @return true or false.
     * @throws BombermanException
     * @throws InterruptedException
     */
    public boolean move(Cell source, Cell dest) throws BombermanException, InterruptedException {
        if (board[dest.getX()][dest.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
            board[source.getX()][source.getY()].unlock();
        } else {
            throw new  BombermanException("Движение в данную клетку невозможно.");
        }
        return true;
    }
}
