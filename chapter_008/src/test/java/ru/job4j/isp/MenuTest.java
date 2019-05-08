package ru.job4j.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 08.05.2019
 */
public class MenuTest {
    private Menu menu;

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        menu = new Menu(new ConsoleInput());
        menu.addEntry(new MenuEntry("Задача 1", 1) {
            @Override
            public void run() {

            }
        });
        menu.addEntry(new MenuEntry("Задача 1.1", 2) {
            @Override
            public void run() {

            }
        });
        menu.addEntry(new MenuEntry("Задача 1.1.1", 3) {
            @Override
            public void run() {

            }
        });
        menu.addEntry(new MenuEntry("Задача 1.1.2", 3) {
            @Override
            public void run() {

            }
        });
        menu.addEntry(new MenuEntry("Задача 1.2", 2) {
            @Override
            public void run() {

            }
        });
        System.setOut(new PrintStream(this.output));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void menuTest() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n"
        + "Menu:\n"
        + "1) Задача 1\n"
        + "2)   Задача 1.1\n"
        + "3)     Задача 1.1.1\n"
        + "4)     Задача 1.1.2\n"
        + "5)   Задача 1.2\n"
        + "6) Exit\n");
        String result = builder.toString();
        menu.printMenu();
        assertThat(new String(this.output.toByteArray()), is(result));
    }
}