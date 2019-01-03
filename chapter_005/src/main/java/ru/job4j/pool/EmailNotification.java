package ru.job4j.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 04.01.2019
 */
public class EmailNotification {

    private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        pool.submit(() -> {
            String subject = "Notification " + user.getUsername() + " to email " + user.getEmail();
            String body = "Add a new event to " + user.getUsername();
            send(subject, body, user.getEmail());
        });
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String suject, String body, String email) {

    }
}
