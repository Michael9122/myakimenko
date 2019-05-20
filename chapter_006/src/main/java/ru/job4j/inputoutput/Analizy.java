package ru.job4j.inputoutput;

import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            String line;
            String pair = null;
            boolean start = false;
            while ((line = reader.readLine()) != null) {
                if (line.matches("[45]00.*") && !start) {
                    pair = line.split("\\s")[1];
                    start = true;
                }
                if (line.matches("[23]00.*") && start) {
                    out.format("%s -> %s%n", pair, line.split("\\s")[1]);
                    start = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("chapter_006/src/main/unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
