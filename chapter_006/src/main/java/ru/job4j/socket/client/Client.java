package ru.job4j.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void clientStart() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str;
        String line;
        do {
            str = console.nextLine();
            out.println(str);
            line = in.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
            }
        } while (!str.equals("bye"));
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 1111)) {
            new Client(socket).clientStart();
        }
    }
}
