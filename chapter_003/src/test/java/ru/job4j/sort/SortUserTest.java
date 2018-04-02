package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortUserListByAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("John", 21));
        list.add(new User("Alex", 19));
        list.add(new User("Mike", 33));
        TreeSet<User> result = (TreeSet<User>) sortUser.sort(list);
        assertThat(result.first().getName(), is("Alex"));
    }
}
