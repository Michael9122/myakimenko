package ru.job4j.isp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 08.05.2019
 */
public class ConsoleInput implements Input {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String ask(String question) {
        System.out.println(question);
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
