package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 24.02.2018
 * @version 1
 */
public class StartUITest {
    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String menu() {
        String menu = new StringJoiner(System.lineSeparator())
                .add("Меню.")
                .add("0. Добавить новую заявку")
                .add("1. Показать все заявки")
                .add("2. Редактировать заявку")
                .add("3. Удалить заявку")
                .add("4. Найти заявку по id")
                .add("5. Найти заявку по имени")
                .add("6. Выход")
                .toString();
        return menu;

    }

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    /**
     * Добавление заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * Изменение заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Поиск заявки по id.
     */
    @Test
    public void whenFindByIdThenShowItemName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "testDescription1", 123L));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }

    @Test
    public void whenShowAllThenPrintAlItemsInTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add(this.menu())
                                .add("------------ Показать все заявки --------------")
                                .add("Заявка: " + item.getName())
                                .add(this.menu())
                                .add("")
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByNameThenPrintSelectedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add(this.menu())
                                .add("------------ Поиск заявки по имени --------------")
                                .add("Заявка: " + item.getName())
                                .add(this.menu())
                                .add("")
                                .toString()
                )
        );
    }
}
