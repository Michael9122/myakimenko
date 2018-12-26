package ru.job4j.nonblocking;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 26.12.2018
 * @version 1
 */
public class Base {
    int id;
    int version;

    public Base(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }
}
