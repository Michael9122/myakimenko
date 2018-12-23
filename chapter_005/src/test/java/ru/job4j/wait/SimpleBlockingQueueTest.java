package ru.job4j.wait;

import org.junit.Test;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 21.12.2018
 * @version 1
 */
public class SimpleBlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s положил %s", Thread.currentThread().getName(), i));
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s достал %s", Thread.currentThread().getName(), i));
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }
}