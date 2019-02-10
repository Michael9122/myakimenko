package ru.job4j.bomberman.exceptions;

public class BombermanException extends Exception {
    public BombermanException() {
    }

    public BombermanException(String message) {
        super(message);
    }

    public BombermanException(String message, Throwable cause) {
        super(message, cause);
    }

    public BombermanException(Throwable cause) {
        super(cause);
    }
}
