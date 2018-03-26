package ru.job4j.chess;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 16.03.2018
 * @version 1
 */
public class Board {

    private Figure[] figures = new Figure[32];

    private int number = 0;

    /**
     * Добавление фигуры на доску.
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[number++] = figure;
    }

    /**
     * Метод проверяет что в заданной ячейке есть фигруа.
     * @param source
     * @return
     */
    public Figure findFigure(Cell source) {
        Figure result = null;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && source.equals(figures[i].position)) {
                result = figures[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод проверяет что полученный путь не зданят фигурами.
     * @param source
     * @param dest
     * @return
     */
    public boolean CheckWay(Cell source, Cell dest) {
        Figure figure = findFigure(source);
        boolean result = false;
        Cell[] check = figure.way(source, dest);
        for (int i = 0; i < check.length; i++) {
            if (findFigure(check[i]) == null) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод проверяет что фигруа может так ходить.
     * @param source
     * @param dest
     * @return
     */
    public boolean figureWay(Cell source, Cell dest) {
        boolean result = false;
        Figure figure = findFigure(source);
            if (figure.way(source, dest) != null) {
                result = true;
            }
        return result;
    }

    /**
     * Метод должен проверить
     * - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     * - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
     * @param source
     * @param dest
     * @return true.
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure figure = findFigure(source);
        if (this.findFigure(source) == null) {
            throw new FigureNotFoundException("Фигура не найдена.");
        }
        if (!this.CheckWay(source, dest)) {
            throw new OccupiedWayException("На пути есть другие фигуры.");
        }
        if (!this.figureWay(source, dest)) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        figure = figure.copy(dest);
        return true;
    }
}