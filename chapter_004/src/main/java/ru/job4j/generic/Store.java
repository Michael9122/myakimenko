package ru.job4j.generic;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 09.06.2018
 * @version 1
 */
public interface Store<T extends Base> {

    /**
     * Добавление.
     * @param model объект который нужно добавить.
     */
    void add(T model);

    /**
     * Замена одного объекта на другой.
     * @param id объекта который нужно жаменить.
     * @param model новый объкет.
     * @return true если получилось заменить объекты, либо false если нет.
     */
    boolean replace(String id, T model);

    /**
     * Удаление объекта.
     * @param id объекта.
     * @return true если получилось удалить объект, либо false если нет.
     */
    boolean delete(String id);

    /**
     * Поиск объекта.
     * @param id объекта.
     * @return искомый объект.
     */
    T findById(String id);
}
