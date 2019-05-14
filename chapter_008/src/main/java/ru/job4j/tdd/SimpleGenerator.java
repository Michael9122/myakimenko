package ru.job4j.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator {
    private static final Pattern KEYS = Pattern.compile("\\$\\{.*?}");

    public String generate(Map<String, String> key, String line) throws Exception {
        Matcher matcher = KEYS.matcher(line);
        if (key.isEmpty()) {
            throw new Exception("No Keys");
        }
        while (matcher.find()) {
            String tmp = line.substring(matcher.start() + 2, matcher.end() - 1);
            line = line.replaceAll("\\$\\{" + tmp + "}", key.get(tmp));
            matcher = KEYS.matcher(line);
            key.remove(tmp);
        }
        if (!key.isEmpty()) {
            throw new Exception("There are extra keys");
        }
        return line;
    }
}
