package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.12.2018
 * @version 1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (queue.size() >= 3) {
                wait();
            }
            queue.offer(value);
            notify();
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            notify();
            return queue.poll();
        }
    }
}
