package ru.job4j.nonblocking;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 26.12.2018
 * @version 1
 */
public class OptimisticException extends RuntimeException {

    public OptimisticException() {
        super("Не совпадают версии модели.");
    }
}
