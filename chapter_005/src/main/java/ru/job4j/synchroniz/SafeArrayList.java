package ru.job4j.synchroniz;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 20.12.2018
 * @version 1
 */
@ThreadSafe
public class SafeArrayList<E> implements Iterable<E> {

    @GuardedBy("this")
    private DynamicArrayList<E> list;

    public SafeArrayList() {
        this.list = new DynamicArrayList<>();
    }

    public synchronized void add(E value) {
        list.add(value);
    }

    public synchronized E get(int index) {
        return list.get(index);
    }

    private synchronized List<E> copy(DynamicArrayList<E> list) {
        List<E> tempArrayList = new ArrayList<>();
        for (Object o : list) {
            tempArrayList.add((E) o);
        }
        return tempArrayList;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.list).iterator();
    }
}
