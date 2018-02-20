package ru.job4j.Profession;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.02.2018
 * @version 1
 */
public class Teacher extends Profession {

    /**
     * Метод teaches.
     * @param student .
     * @return Строку.
     */
    public String teaches(Student student) {
        return "Учитель " + getName() + " учит " + student.getName();
    }
}
