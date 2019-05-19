package ru.job4j.inputoutput;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    private Config config;

    @Before
    public void setUp() {
        config = new Config("src/main/app.properties");
    }

    @Test
    public void whenLoadFileThenMethodValueReturnKey() {
        config.load();
        System.out.println();
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }
}