package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;

    private int age;

    public User (String name, int age) {
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
        return String.format("%s, %d лет", this.name, this.age);
    }
}
