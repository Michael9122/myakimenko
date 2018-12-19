package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 19.12.2018
 * @version 1
 */
public class UserStorageTest {

    private UserStorage storage = new UserStorage();
    private User userOne = new User(1, 100);
    private User userTwo = new User(2, 200);

    @Before
    public void setUp() {
        storage.add(userOne);
        storage.add(userTwo);
    }

    @Test
    public void whenAddUserThenTrue() {
        assertThat(storage.add(new User(3, 300)), is(true));
    }

    @Test
    public void whenDeleteThenTrue() {
        assertThat(storage.delete(userTwo), is(true));
    }

    @Test
    public void whenUpdateThenTrue() {
        assertThat(storage.update(new User(2, 300)), is(true));
    }

    @Test
    public void transfer() {
        storage.transfer(1, 2, 50);
        assertThat(userOne.getAmount(), is(50));
        assertThat(userTwo.getAmount(), is(250));
    }
}