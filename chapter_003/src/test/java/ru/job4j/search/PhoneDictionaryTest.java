package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 26.03.2018
 * @version 1
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Michael", "Yakimenko", "534872", "Krasnodar")
        );
        List<Person> persons = phones.find("Michael");
        assertThat(persons.iterator().next().getSurname(), is("Yakimenko"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Michael", "Yakimenko", "534872", "Krasnodar")
        );
        List<Person> persons = phones.find("534872");
        assertThat(persons.iterator().next().getSurname(), is("Yakimenko"));
    }
}
