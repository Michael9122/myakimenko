package ru.job4j.test;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
public class Info {

    private int Insert;
    private int Replace;
    private int Delete;

    public Info(int insert, int replace, int delete) {
        Insert = insert;
        Replace = replace;
        Delete = delete;
    }

    public int getInsert() {
        return Insert;
    }

    public int getDelete() {
        return Delete;
    }

    public int getReplace() {
        return Replace;
    }

    @Override
    public String toString() {
        return "Info{" +
                "Insert=" + Insert +
                ", Replace=" + Replace +
                ", Delete=" + Delete +
                '}';
    }
}
