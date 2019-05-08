package ru.job4j.isp;

import java.util.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 08.05.2019
 */
public class Menu {
    private List<MenuEntry> entries = new ArrayList<>();
    private boolean isExit = false;
    private Input input;

    public Menu(Input input) {
        this.input = input;
        entries.add(0, new MenuEntry("Exit", 1) {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public void run() {
        while (!isExit) {
            printMenu();
            int choice = Integer.parseInt(input.ask("Выберите действие"));
            MenuEntry entry = entries.get(choice - 1);
            entry.run();
        }
    }

    public Menu addEntry(MenuEntry entry) {
        int index = entries.size() - 1;
        entries.add(index, entry);
        return this;
    }

    public void printMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nMenu:\n");
        for (int i = 0; i < entries.size(); i++) {
            MenuEntry entry = entries.get(i);
            builder.append(i + 1 + ")");
            for (int j = 1; j < entry.getLevel(); j++) {
                builder.append("  ");
            }
            builder.append(" " + entry.getTitle() + "\n");
        }
        System.out.print(builder.toString());
    }
}
