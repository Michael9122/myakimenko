package ru.job4j.chess;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 16.03.2018
 * @version 1
 */
public class Board {

    private Figure[] figures = new Figure[32];

    private int numberOfFigures = 0;

    private Cell[] cells = new Cell[64];

    /**
     * Добавление фигуры на доску.
     * @param figure
     */
    public void add(Figure figure) {
        figures[numberOfFigures++] = figure;
    }

    /**
     * Метод должен проверить
     * - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     * - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        boolean findFigure = false;
        int index = 0;

        for (Figure figure : figures) {
            if (figure != null) {
                if (figure.position.getX() == source.getX() && figure.position.getY() == source.getY()) {
                    findFigure = true;
                    index++;
                    break;
                } else {
                    throw new FigureNotFoundException("Фигура не найдена.");
                }
            }
        }
        if (findFigure) {
            for (int i = 0; i <= figures.length; i++) {
                if (figures[i].position.getY() != dest.getY() && figures[i].position.getX() != dest.getX()) {
                    if (figures[index].way(source, dest) != null) {
                        figures[index] = figures[index].copy(dest);
                        result = true;
                    } else {
                        throw new ImpossibleMoveException("Фигура не может так ходить.");
                    }
                } else {
                    throw new OccupiedWayException("Данная клетка уже занята.");
                }
            }
        }
        return result;
    }
}