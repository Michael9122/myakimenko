package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 06.05.2018
 * @version 1
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getPassport(), user.getPassport())
                && Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + this.name + '\''
                + "pasport='" + this.passport + '}';
    }
}
