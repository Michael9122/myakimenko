package ru.job4j.pattern;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
