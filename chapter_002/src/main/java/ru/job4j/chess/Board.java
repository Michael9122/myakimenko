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

        for (int i = 0; i < figures.length - 1; i++) {
            if (figures[i] != null && source.equals(figures[i].position)) {
                index = i;
                findFigure = true;
                break;
            }
        }
        if (findFigure) {
            if (figures[index].way(source, dest) != null) {
                for (Cell way : figures[index].way(source, dest)) {
                    for (int i = 0; i <= figures.length; i++) {
                        if (figures[i] != null && (way.getX() == figures[i].position.getX()) && (way.getY() == figures[i].position.getY())) {
                            throw new OccupiedWayException("Данная клетка уже занята.");
                        } else {
                            figures[index] = figures[index].copy(dest);
                            result = true;
                            break;
                        }
                    }
                }
            } else {
                throw new ImpossibleMoveException("Фигура не может так ходить.");
            }
        } else {
            throw new FigureNotFoundException("Фигура не найдена.");
        }

        return result;
    }
}