package ru.job4j.map;

import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 10.07.2018
 * @version 1
 */
public class MapTest {

    private Map<User, Integer> map = new HashMap<>();

    @Test
    public void map() {
        User userOne = new User("Michail", 0, new GregorianCalendar(1996, 02, 22));
        User userTwo = new User("Michail", 0, new GregorianCalendar(1996, 02, 22));
        map.put(userOne, 1);
        map.put(userTwo, 2);
        System.out.println(map);
        System.out.println(map.size());
    }
}