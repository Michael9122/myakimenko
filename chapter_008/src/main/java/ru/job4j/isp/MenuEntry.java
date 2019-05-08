package ru.job4j.isp;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 08.05.2019
 */
public abstract class MenuEntry {
    private String title;
    private int level;

    public MenuEntry(String title, int level) {
        this.title = title;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void run();
}
