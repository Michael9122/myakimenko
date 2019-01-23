package ru.job4j.inputOutput;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckStreamTest {

    @Test
    public void whenIsNumberEvenThenTrue() throws IOException {
        CheckStream check = new CheckStream();
        assertThat(check.isNumber(new ByteArrayInputStream("22".getBytes())), is(true));
    }

    @Test
    public void whenIsNumberNotEvenThenFalse() throws IOException {
        CheckStream check = new CheckStream();
        assertThat(check.isNumber(new ByteArrayInputStream("23".getBytes())), is(false));
    }
}