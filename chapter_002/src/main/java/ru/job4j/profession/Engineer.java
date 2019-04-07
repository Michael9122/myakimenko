package ru.job4j.profession;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.02.2018
 * @version 1
 */
public class Engineer extends Profession {

    /**
     * Метод builds.
     * @param home .
     * @return Строку.
     */
    public String builds(Home home) {
        return "Инженер " + getName() + " строит " + home.getName();
    }
}
