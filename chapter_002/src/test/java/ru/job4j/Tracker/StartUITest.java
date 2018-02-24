package ru.job4j.Tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 24.02.2018
 * @version 1
 */
public class StartUITest {
    /**
     * Добавление заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName(){
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
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
}
