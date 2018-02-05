package ru.job4j.loop;

/**
 * Класс для создания шахматной доски в псевдографике.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 05.02.2018
 * @version 1
 */
public class Board {

    /**
     * Method paint.
     * @param width ширина достки.
     * @param height это высота доски.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
                System.getProperty("line.separator");
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
