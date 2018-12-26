package ru.job4j.nonblocking;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 26.12.2018
 * @version 1
 */
public class StorageTest {

        @Test
        public void whenThrowException() throws InterruptedException {
            Storage storage = new Storage();
            storage.add(new Base(1));
            AtomicReference<Exception> ex = new AtomicReference<>();
            Thread thread = new Thread(
                    () -> {
                        try {
                            storage.update(new Base(1));
                        } catch (OptimisticException e) {
                            ex.set(e);
                        }
                    }
            );
            Thread thread2 = new Thread(
                    () -> {
                        try {
                            storage.update(new Base(1));
                        } catch (OptimisticException e) {
                            ex.set(e);
                        }
                    }
            );
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
            Assert.assertThat(ex.get().getMessage(), is("Не совпадают версии модели."));
        }
}