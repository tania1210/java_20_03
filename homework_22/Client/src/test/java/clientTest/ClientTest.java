package clientTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.Client;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private Socket mockSocket;
    private Client client;

    @Before
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
        try {
            if (mockSocket != null) {
                mockSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClientConnection() throws IOException {
        // Симуляція з'єднання клієнта з сервером
        String testMessage = "Test message";
        testIn = new ByteArrayInputStream(testMessage.getBytes());
        System.setIn(testIn);

        // Симуляція серверного сокету
        mockSocket = new MockSocket();
        client = new Client(mockSocket);

        // Очікуємо, що клієнт надішле тестове повідомлення
        assertTrue(client.sendMessage());

        // Очікуємо, що клієнт отримає відповідь від сервера
//        assertTrue(client.receiveMessage());
//        assertEquals("Server response: " + testMessage, testOut.toString().trim());
    }

    private class MockSocket extends Socket {
        private InputStream inputStream;
        private OutputStream outputStream;

        public MockSocket() throws IOException {
            inputStream = new ByteArrayInputStream("Server response: Test message".getBytes());
            outputStream = new ByteArrayOutputStream();
        }

        @Override
        public InputStream getInputStream() {
            return inputStream;
        }

        @Override
        public OutputStream getOutputStream() {
            return outputStream;
        }
    }
}
