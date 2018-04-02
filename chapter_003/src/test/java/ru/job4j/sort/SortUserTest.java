package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
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

    @Test
    public void whenSortByLengthName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("John", 21));
        list.add(new User("Tom", 19));
        list.add(new User("Eleanor", 33));
        sortUser.sortNameLength(list);
        assertThat(list.get(0).getName(), is("Tom"));
    }

    @Test
    public void whenSortByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("John", 25));
        list.add(new User("Eleanor", 30));
        list.add(new User("John", 20));
        list.add(new User("Eleanor", 25));
        sortUser.sortByAllFields(list);
        assertThat(list.get(0).toString(), is("Eleanor, 25 age"));
        assertThat(list.get(3).toString(), is("John, 25 age"));
    }
}
