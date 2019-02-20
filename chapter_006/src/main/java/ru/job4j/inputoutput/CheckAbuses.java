package ru.job4j.inputoutput;

import java.io.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 20.02.2019
 * @version 1
 */
public class CheckAbuses {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String s : abuse) {
                    line = line.replaceAll(s, "");
                }
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
