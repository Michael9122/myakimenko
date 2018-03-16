package ru.job4j.chess;

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
        int count = 0;
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        if (Math.abs(sourceX - destX) == Math.abs(sourceY - destY)) {
            Cell[] way = new Cell[Math.abs(sourceY - destY)];
            for (int i = 1; i <= (Math.abs(sourceX - destX)); i++) {
                way[count++] = new Cell(sourceX + (destX - sourceX), sourceY + (destY - sourceY));
            }
            return way;
        } else {
            throw new ImpossibleMoveException("Фигура не может туда пойти.");
        }
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
