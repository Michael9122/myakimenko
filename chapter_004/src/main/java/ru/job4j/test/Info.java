package ru.job4j.test;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
public class Info {

    private int insert;
    private int replace;
    private int delete;

    public Info(int insert, int replace, int delete) {
        this.insert = insert;
        this.replace = replace;
        this.delete = delete;
    }

    public int getInsert() {
        return insert;
    }

    public int getDelete() {
        return delete;
    }

    public int getReplace() {
        return replace;
    }

    @Override
    public String toString() {
        return "Info{"
                + "insert=" + insert
                + ", replace=" + replace
                + ", delete=" + delete
                + '}';
    }
}
