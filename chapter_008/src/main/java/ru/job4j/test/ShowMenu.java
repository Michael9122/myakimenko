package ru.job4j.test;

public class ShowMenu implements Draw {

    @Override
    public void draw(String[][] board) {
        int d = 0;
        System.out.print("y\\x");
        for (int i = 0; i < board.length; i++) {
            System.out.print("  " + i + ":");
        }
        System.out.println();
        printDivider(board);
        for (int i = 0; i < board.length; i++) {
            System.out.print(d + ": | ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            printDivider(board);
            d++;
        }
    }

    private void printDivider(String[][] board) {
        System.out.print("    ");
        for (int i = 0; i < board.length - 1; i++) {
            System.out.print("----");
        }
        System.out.println("---");
    }
}
