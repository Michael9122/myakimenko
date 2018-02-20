package ru.job4j.Profession;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.02.2018
 * @version 1
 */
public class Profession {
    /**
     * Поле name.
     */
    public String name;

    /**
     * Поле profession.
     */
    public String profession;

    /**
     * Метод возвращает имя.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод возвращает имя.
     * @return profession.
     */
    public String getProfession() {
        return this.profession;
    }

    /**
     * Метод передает Name.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }
}
