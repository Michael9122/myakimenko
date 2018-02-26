package ru.job4j.tracker;

import java.util.Random;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 22.02.2018
 * @version 1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Поле для созданлия рандомных чисел.
     */
    private static final Random RND = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод заменяет ячейку в массиве.
     * @param id
     * @param item
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.items.length; index++) {
            if (items[index] != null && this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Метод удаляет ячейку в массиве.
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index != this.items.length; index++) {
            if (items[index] != null && this.items[index].getId().equals(id)) {
                this.position = index;
                break;
            }
        }
        System.arraycopy(this.items, this.position + 1, this.items, this.position, this.items.length - 1 - this.position);
    }

    /**
     * Метод находит элемент по id.
     * @param id
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
     * @param key
     * @return массив.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[count] = item;
                count++;
            }
        }
        return result;
    }

    /**
     * Метод findAll возвращает копию массива this.items без null элементов.
     * @return result.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }

}
