package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void searchFileEndsWithLog() {
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add(".log");
        List<File> result = search.files("src", exts);
        assertThat(result.size(), is(1));
    }
}