package ru.job4j.nonblocking;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 26.12.2018
 * @version 1
 */
public class Storage {

    ConcurrentHashMap<Integer, Base> hashMap = new ConcurrentHashMap<>();

    public void add(Base model) {
        hashMap.put(model.getId(), model);
    }

    public void update(Base model) {
        hashMap.computeIfPresent(model.getId(), (integer, base) -> {
            if (model.getVersion() != base.getVersion()) {
                throw new OptimisticException();
            }
            model.version++;
            return model;
        });
    }

    public void delete(Base model) {
        hashMap.remove(model.getId());
    }
}
