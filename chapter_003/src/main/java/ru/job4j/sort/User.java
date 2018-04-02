package ru.job4j.sort;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class User implements Comparable<User> {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }

    @Override
    public String toString() {
        return String.format("%s, %d age", this.name, this.age);
    }
}
