package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class SortUser {

    /**
     * Сортировка по возрасту.
     * @param list список.
     * @return отсортированный TreeSet.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * Сортировка по длине имени.
     * @param users список.
     * @return отсортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    /**
     * Сортировка по длине имени и по возрасту.
     * @param users список.
     * @return отсортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int sort = o1.getName().compareTo(o2.getName());
                return sort != 0 ? sort : o1.getAge() - o2.getAge();
            }
        });
        return users;
    }
}
