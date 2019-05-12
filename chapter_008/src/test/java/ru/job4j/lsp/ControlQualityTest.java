package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 06.05.2019
 */
public class ControlQualityTest {
    private ControlQuality controlQuality = new ControlQuality();

    private Shop shop = new Shop();

    private Warehouse warehouse = new Warehouse();

    private Trash trash = new Trash();

    @Test
    public void testTrash() {
        controlQuality.setStrategy(trash);
        Food food = new Food("meat", LocalDate.parse("2019-05-05"), LocalDate.parse("2019-05-01"), 500, 100);
        controlQuality.executeStrategy(food);
        assertThat(trash.getList().get(0), is(food));
    }

    @Test
    public void testWarehouse() {
        controlQuality.setStrategy(warehouse);
        Food food = new Food("milk", LocalDate.parse("2019-06-12"), LocalDate.parse("2019-05-06"), 500, 100);
        controlQuality.executeStrategy(food);
        assertThat(warehouse.getList().get(0), is(food));
    }
}