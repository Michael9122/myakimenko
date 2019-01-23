package ru.job4j.inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CheckStream {

    public boolean isNumber(InputStream in) throws IOException {
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0) {
                result = true;
            }
            return result;
        }
    }
}
