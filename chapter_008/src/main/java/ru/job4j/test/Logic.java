package ru.job4j.test;

public class Logic {

    private InputOutput inputOutput;

    private Draw showMenu;

    private String[][] board;

    private final int rows;

    private final int cols;

    private String regex = "\\s";

    private char player = 'O';

    public Logic(InputOutput inputOutput, Draw showMenu, int rows, int cols) {
        this.inputOutput = inputOutput;
        this.showMenu = showMenu;
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void go() {
        do {
            showMenu.draw(board);
            takeCell();
            if (isGameOver()) {
                System.out.println("\n" + player + " wins!");
                break;
            }
        } while (true);
    }

    private void takeCell() {
        getPlayer();
        int row = inputOutput.question("Enter coordinates for rows: ");
        int col = inputOutput.question("Enter coordinates for column: ");
        if (row > board.length && col > board.length) {
            throw new IllegalArgumentException();
        }
        if (board[row][col].matches(regex)) {
            board[row][col] = "" + player;
        }
    }

    private void getPlayer() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    private boolean isGameOver() {
        for (int i = 0; i < rows; i++) {
            if (!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (!board[0][j].matches(regex) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return true;
            }
        }
        if (!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        }
        if (!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return true;
        }
        return false;
    }
}
