package ru.job4j.chess;

import java.util.Arrays;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 16.03.2018
 * @version 1
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Метод реализует движение слона.
     *  dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     *  Если фигура туда пойти не может. выбросить исключение ImpossibleMoveException.
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] path = new Cell[7];
        int moveX = source.getX();
        int moveY = source.getY();
        if (Math.abs(dest.getX() - source.getX()) != Math.abs(dest.getY() - source.getY())) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        moveX = dest.getX() > moveX ? ++moveX : --moveX;
        moveY = dest.getY() > moveY ? ++moveY : --moveY;
        for (int i = 0; i < Math.abs(dest.getX() - source.getX()); i++) {
            path[i] = new Cell(moveX, moveY);
        }
        return Arrays.copyOf(path, Math.abs(dest.getX() - source.getX()));
    }

    /**
     * Метод создает фигуру с координатой dest.
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
