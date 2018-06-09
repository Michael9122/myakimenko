package ru.job4j.generic;

import java.util.Iterator;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 09.06.2018
 * @version 1
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray array;

    /**
     * Конструктор.
     * @param array экземпляр класса SimpleArray.
     */
    public AbstractStore(SimpleArray array) {
        this.array = array;
    }

    /**
     * Добавление.
     * @param model объект который нужно добавить.
     */
    @Override
    public void add(T model) {
        array.add(model);
    }

    /**
     * Замена одного объекта на другой.
     * @param id объекта который нужно жаменить.
     * @param model новый объкет.
     * @return true если получилось заменить объекты, либо false если нет.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        Iterator<T> it = array.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                array.set(index, model);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Удаление объекта.
     * @param id объекта.
     * @return true если получилось удалить объект, либо false если нет.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        Iterator<T> it = array.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                array.delete(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Поиск объекта.
     * @param id объекта.
     * @return искомый объект.
     */
    @Override
    public T findById(String id) {
        Iterator<T> it = array.iterator();
        while (it.hasNext()){
            T role = it.next();
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }
}
