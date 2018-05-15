package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.03.2018
 * @version 1
 */
public class BoardTest {
    @Test
    public void whenMoveThenSuccess() {
        Board board = new Board();
        Cell cell = new Cell(4, 4);
        board.add(new Bishop(cell));
        assertThat(board.move(cell, new Cell(2, 2)), is(true));
    }

    @Test
    public void whenFigureSecondMoveThenSuccess() {
        Board board = new Board();
        Cell cell = new Cell(4, 4);
        Cell cellTwo = new Cell(1, 1);
        board.add(new Bishop(cell));
        board.add(new Bishop(cellTwo));
        assertThat(board.move(cellTwo, new Cell(2, 2)), is(true));
    }

    @Test
    public void whenHaveNoFigureInCellThenThrowException() {
        Board board = new Board();
        Cell cellFigure = new Cell(2, 1);
        Cell cellSrc = new Cell(1, 1);
        Cell cellDst = new Cell(3, 3);
        board.add(new Bishop(cellFigure));
        try {
            board.move(cellSrc, cellDst);
        } catch (FigureNotFoundException fne) {
            assertThat(fne.getMessage(), is("Фигура не найдена."));
        }
    }
    @Test
    public void whenFigureCantMoveInDestCellThenThrowException() {
        Board board = new Board();
        Cell cellSrc = new Cell(1, 1);
        Cell cellDst = new Cell(2, 3);
        board.add(new Bishop(cellSrc));
        try {
            board.move(cellSrc, cellDst);
        } catch (ImpossibleMoveException ime) {
            assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenOtherFigureOnTheWayThenThrowException() {
        Board board = new Board();
        Cell cellFigure2 = new Cell(3, 3);
        Cell cellSrc = new Cell(2, 2);
        Cell cellDst = new Cell(4, 4);

        board.add(new Bishop(cellSrc));
        board.add(new Bishop(cellFigure2));
        try {
            board.move(cellSrc, cellDst);
        } catch (OccupiedWayException owe) {
            assertThat(owe.getMessage(), is("На пути есть другие фигуры."));
        }
    }
}
