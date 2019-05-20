package ru.job4j.inputoutput;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    private Analizy analizy;

    private File file;

    @Before
    public void setUp() {
        analizy = new Analizy();
        file = new File("src/main/unavailable.csv");
    }

    @After
    public void tearDown() {
        file.delete();
    }

    @Test
    public void whenUseMethodUnavailableThenCreateFileDate() throws IOException {
        analizy.unavailable("src/main/source.log", "src/main/unavailable.csv");
        List<String> result = Files.readAllLines(Paths.get("src/main/unavailable.csv"));
        assertThat(result.get(0), is("10:58:01 -> 10:59:01"));
        assertThat(result.get(1), is("11:01:02 -> 11:02:02"));
    }
}