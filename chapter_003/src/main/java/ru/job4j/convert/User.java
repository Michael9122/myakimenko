package ru.job4j.convert;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User (int id, String name, String city) {
        this.city = city;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
