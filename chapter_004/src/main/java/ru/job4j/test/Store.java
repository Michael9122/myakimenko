package ru.job4j.test;

import java.util.List;
import java.util.Objects;

/**
 * @author Michael Yakimenko (mailto:Mixail912@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
public class Store {

    /**
     * Метод сравнивает два листа и проверяет какие в них были изменения и сколько.
     * @param previous предыдущий.
     * @param current текущий.
     * @return info с данными об ихменениях.
     */
    Info diff(List<User> previous, List<User> current) {
        int insert, delete = 0, replace = 0;
        int index;
        for (User user : current) {
            if (previous.contains(user)) {
                index = current.indexOf(user);
                if (!user.getName().equals(previous.get(index).getName()) & user.getId() == previous.get(index).getId()) {
                    replace++;
                }
            }
        }
        for (User user : previous) {
            if (!current.contains(user)) {
                delete++;
            }
        }
        insert = current.size() - (previous.size() - delete);
        Info info = new Info(insert, replace, delete);
        return info;
    }

    static class User {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
