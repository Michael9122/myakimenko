package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    private SimpleGenerator generator;

    private Map<String, String> map;

    @Before
    public void setUp() {
        generator = new SimpleGenerator();
        map = new HashMap<>();
    }

    @Test
    public void generateTwoWord() {
        map.put("name", "M");
        map.put("subject", "Y");
        String line = "I am a ${name}, Who are ${subject}?";
        try {
            assertThat(generator.generate(map, line), is("I am a M, Who are Y?"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateThreeWord() {
        map.put("sos", "Aaa");
        String line = "Help, ${sos}, ${sos}, ${sos}";
        try {
            assertThat(generator.generate(map, line), is("Help, Aaa, Aaa, Aaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDontHaveAnyKeys() {
        String line = "I am a ${name}, Who are ${subject}?";
        try {
            assertThat(generator.generate(map, line), is("No Keys"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenHaveExtraKeys() {
        map.put("name", "M");
        map.put("subject", "Y");
        map.put("extra", "keys");
        String line = "I am a ${name}, Who are ${subject}?";
        try {
            assertThat(generator.generate(map, line), is("There are extra keys"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}