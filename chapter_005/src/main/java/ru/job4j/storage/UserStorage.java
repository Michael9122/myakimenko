package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.12.2018
 * @version 1
 */
@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private Map<Integer, User> users = new HashMap<>();

    public synchronized boolean add(User user) {
        boolean result = false;
        if (!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        if (users.containsKey(user.getId())) {
            users.remove(user.getId());
            result = true;
        }
        return result;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        if (amount > 0 && users.get(fromId).getAmount() >= amount) {
            users.get(fromId).setAmount(users.get(fromId).getAmount() - amount);
            users.get(toId).setAmount(users.get(toId).getAmount() + amount);
        }
    }
}
