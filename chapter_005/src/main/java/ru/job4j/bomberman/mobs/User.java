package ru.job4j.bomberman.mobs;

import ru.job4j.bomberman.Board;
import ru.job4j.bomberman.Cell;
import ru.job4j.bomberman.exceptions.BombermanException;

import java.util.Random;

public class User extends Mob implements Runnable {

    private Cell position;
    private Board board;

    public User(Cell position, final Board board) {
        super(position);
        this.board = board;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Random random = new Random();
                int x = -1 + random.nextInt(3);
                int y = -1 + random.nextInt(3);
                if (board.move(position, new Cell(position.getX() + x, position.getY() + y))) {
                    setPosition(new Cell(position.getX() + x, position.getY() + y));
                }
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            } catch (BombermanException e) {
                e.printStackTrace();
            }
        }
    }

}
