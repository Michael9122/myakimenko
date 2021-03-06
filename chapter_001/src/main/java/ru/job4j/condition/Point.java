package ru.job4j.condition;

/**
 * Класс для вычесления расстояния между точками в системе координат.
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычесления расстояния.
     * @param that точки.
     * @return расстояние.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Ввод точек.
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(2, 4);
        Point b = new Point(4, 3);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
