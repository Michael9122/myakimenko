package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class UserConvertTest {
    @Test
    public void whenConvertListToMapThenReturnMap() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Михаил", "Краснодар"));
        list.add(new User(2, "Валера", "Новосибирск"));
        assertThat(convert.process(list).get(1).getName(), is("Михаил"));
    }
}
