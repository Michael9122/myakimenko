package ru.job4j.Tracker;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 28.02.2018
 * @version 1
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
