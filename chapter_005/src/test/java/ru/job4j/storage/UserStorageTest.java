package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {

    UserStorage storage;
    User userOne;
    User userTwo;

    @Before
    public void setUp() {
        storage = new UserStorage();
        userOne = new User(1, 100);
        userTwo = new User(2, 200);
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