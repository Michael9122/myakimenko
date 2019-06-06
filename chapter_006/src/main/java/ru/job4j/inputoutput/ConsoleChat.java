package ru.job4j.inputoutput;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private boolean stop = true;

    private boolean pause = true;

    private Scanner in = new Scanner(System.in);

    public void chat(File file) throws FileNotFoundException {
        do {
            String answer = in.nextLine();
            check(answer);
            if (pause) {
                System.out.println(choose(file));
            }
        } while (stop);
    }

    private String choose(File f) throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(f); sc.hasNext(); ++n) {
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0) {
                result = line;
            }
        }
        return result;
    }

    private void check(String answer) {
        if (answer.equals("закончить")) {
            stop = false;
        } else if (answer.equals("стоп")) {
            pause = false;
        } else if (answer.equals("продолжить")) {
            pause = true;
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat();
        try {
            chat.chat(new File("./chapter_006/answers"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
