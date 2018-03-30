package ru.job4j.tracker;

import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 24.02.2018
 * @version 1
 */
public class StartUI {

    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
