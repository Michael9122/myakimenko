package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
