package ru.job4j.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void serverStart() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if (ask.equals("Hello")) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (ask.equals("bye")) {
                out.println("Good bye!");
                out.println();
            } else {
                out.println("i don't understand");
                out.println();
            }
        } while (!ask.equals("bye"));
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(1111).accept()) {
            new Server(socket).serverStart();
        }
    }
}
