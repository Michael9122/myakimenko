package ru.job4j.pinpong;

import javafx.scene.shape.Rectangle;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 12.12.2018
 * @version 1
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int limitX;
    private int limitY;

    public RectangleMove(Rectangle rect, int limitX, int limitY) {
        this.rect = rect;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    @Override
    public void run() {
        int x = 3;
        int y = 5;
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + x);
            this.rect.setY(this.rect.getY() + y);
            if (this.rect.getX() >= limitX || this.rect.getX() <= 0) {
                x = -x;
            }
            if (this.rect.getY() >= limitY || this.rect.getY() <= 0) {
                y = -y;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}