package ru.job4j.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<Integer, String> curr = new HashMap<>();
        Map<Integer, String> prev = new HashMap<>();
        for (User user : previous) {
            prev.put(user.getId(), user.getName());
        }
        for (User user : current) {
            curr.put(user.getId(), user.getName());
        }
        for (Integer user : prev.keySet()) {
            if (!curr.keySet().contains(user)) {
                delete++;
            } else if (!prev.get(user).equals(curr.get(user))) {
                replace++;
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
