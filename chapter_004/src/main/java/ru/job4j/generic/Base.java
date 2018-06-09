package ru.job4j.generic;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 09.06.2018
 * @version 1
 */
public abstract class Base {

    /**
     * id объекта.
     */
    private final String id;

    /**
     * Конструктор.
     * @param id объекта.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Получение id объекта.
     * @return id объекта.
     */
    public String getId() {
        return id;
    }
}
