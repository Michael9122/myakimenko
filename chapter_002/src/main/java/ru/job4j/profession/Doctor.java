package ru.job4j.profession;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.02.2018
 * @version 1
 */
public class Doctor extends Profession {

    /**
     * Метод heal.
     * @param patient .
     * @return Строку.
     */
    public String heal(Patient patient) {
        return "Доктор " + getName() + " лечит " + patient.getName();
    }
}
