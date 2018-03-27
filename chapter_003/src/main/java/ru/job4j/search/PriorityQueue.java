package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 27.03.2018
 * @version 1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача.
     */
    public void put(Task task) {
        int index = 0;
        for (Task i : tasks) {
            if (task.getPriority() < i.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
