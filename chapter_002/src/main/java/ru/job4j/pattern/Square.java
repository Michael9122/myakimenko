package ru.job4j.pattern;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        return pic.toString();
    }
}
