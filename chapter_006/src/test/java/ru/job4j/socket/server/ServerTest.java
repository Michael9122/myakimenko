package ru.job4j.socket.server;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private final String ln = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.serverStart();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        this.testServer(Joiner.on(ln).join(
                "Hello",
                "bye"
                ),
                Joiner.on(ln).join(
                        "Hello, dear friend, I'm a oracle.",
                        "",
                        "Good bye!",
                        "",
                        ""
                )
        );
    }
}