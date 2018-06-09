package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 09.06.2018
 * @version 1
 */
public class StoreTest {

    private Store<User> userStore;
    private Store<Role> roleStore;
    private Role role1;
    private Role role2;
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        userStore = new UserStore(new SimpleArray(2));
        roleStore = new RoleStore(new SimpleArray(2));
        role1 = new Role("1");
        role2 = new Role("2");
        user1 = new User("1");
        user2 = new User("2");
        userStore.add(user1);
        userStore.add(user2);
        roleStore.add(role1);
        roleStore.add(role2);
    }

    @Test
    public void whenAddThenShouldReturnId() {
        assertThat(userStore.findById("1"), is(user1));
        assertThat(userStore.findById("2"), is(user2));
        assertThat(roleStore.findById("1"), is(role1));
        assertThat(roleStore.findById("2"), is(role2));
    }

    @Test
    public void whenReplaceThenTrue() {
        assertThat(userStore.replace("1", new  User("3")), is(true));
        assertThat(roleStore.replace("1", new Role("3")), is(true));
    }

    @Test
    public void whenDeleteThenTrue() {
        assertThat(userStore.delete("2"), is(true));
        assertThat(roleStore.delete("2"), is(true));
    }
}