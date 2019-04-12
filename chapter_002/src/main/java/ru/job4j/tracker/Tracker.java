package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class Tracker implements ITracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Поле для созданлия рандомных чисел.
     */
    private static final Random RND = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        this.items.add(item);
        item.setId(generateId());
        return item;
    }

    /**
     * Метод заменяет ячейку в массиве.
     * @param id id звявки.
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        items.set(items.indexOf(this.findById(id)), item);
        item.setId(id);
    }

    /**
     * Метод удаляет ячейку в массиве.
     * @param id id звявки.
     */
    public void delete(String id) {
        for (Item j : items) {
            if (j != null && j.getId().equals(id)) {
                int i = items.indexOf(j);
                items.remove(i);
                break;
            }
        }
    }

    /**
     * Метод находит элемент по id.
     * @param id id звявки.
     * @return найденный резултат, либо null если результат не найден.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод находит элемент по названию.
     * @param key Имя.
     * @return массив.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод findAll возвращает копию массива this.items без null элементов.
     * @return result.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt(100));
    }

}
