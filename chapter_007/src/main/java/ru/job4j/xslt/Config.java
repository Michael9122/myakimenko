package ru.job4j.xslt;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 17.04.2019
 */
public class Config {

    private final Properties values = new Properties();

    /**
     * Подключение к БД.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
