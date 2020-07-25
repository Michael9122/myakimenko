package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import java.util.List;

public interface Store {
    Item add(Item item);
    void replace(Integer id, Item item);
    void delete(Integer id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(Integer id);
}