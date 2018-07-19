package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.07.2018
 * @version 1
 */
public class HashMap<K, V> implements Iterable<HashMap.Entry<K, V>> {

    private final int capacity = 16;

    private Entry<K, V>[] table;

    private int size;

    private int modCount;

    public HashMap() {
        this.table = new Entry[capacity];
    }

    /**
     * Вычисление хеш-кода у объекта.
     * @param key ключ.
     * @return хеш-код объекта.
     */
    private static final int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    /**
     * Увелечение размера таблицы.
     */
    private Entry<K, V>[] resize() {
        Entry<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        Entry<K, V>[] newTab = new Entry[table.length * 2];
        for (Entry<K, V> i : oldTab) {
            if (i != null) {
                newTab[hash(i.getKey())] = i;
            }
        }
        table = newTab;
        return newTab;
    }

    /**
     * Добавление объекта в таблицу.
     * @param key ключ.
     * @param value значение.
     * @return true если объект был успешно добавлен, либо false если нет.
     */
    public boolean insert(K key, V value) {
        if (size == table.length) {
            resize();
        }
        boolean result = false;
        int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new Entry<>(key, value);
            result = true;
        }
        modCount++;
        size++;
        return result;
    }

    /**
     * Получение объекта по ключу.
     * @param key ключ.
     * @return значение объекта, либо null если объект не был найден.
     */
    public V get(K key) {
        if (table[hash(key)].getKey().equals(key)) {
            return table[hash(key)].getValue();
        }
        return null;
    }

    /**
     * Получение размера таблицы.
     */
    public int getSize() {
        return size;
    }

    /**
     * Удаление объекта из таблицы.
     * @param key ключ.
     * @return true если объект был удален, либо false если нет.
     */
    public boolean delete(K key) {
        boolean result = false;
        if (table[hash(key)].getKey().equals(key)) {
            table[hash(key)] = null;
            result = true;
            size--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<HashMap.Entry<K, V>> iterator() {

        return new Iterator<HashMap.Entry<K, V>>() {
            int cursor = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                for (int i = cursor; i <= size; i++) {
                    if (table[i] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public HashMap.Entry<K, V> next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Entry<K, V> result = null;
                for (; cursor <= size; cursor++) {
                    if (table[cursor] != null) {
                        result = table[cursor++];
                        break;
                    }
                }
                return result;
            }

            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    static class Entry<K, V> {
        final K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.getKey())
                    && Objects.equals(value, entry.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
