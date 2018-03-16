package ru.job4j.chess;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 16.03.2018
 * @version 1
 */
public abstract class Figure {
    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}
