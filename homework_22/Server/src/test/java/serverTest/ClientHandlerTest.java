package serverTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.ClientHandler;
import server.Server;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandlerTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private Socket mockSocket;
    private Server mockServer;
    private ClientHandler clientHandler;

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
    public void testClientHandlerCommunication() throws IOException {
        // Симуляція з'єднання клієнта з сервером
        String testMessage = "Test message\n"; // Додано символ нового рядка для завершення введення
        testIn = new ByteArrayInputStream(testMessage.getBytes());
        System.setIn(testIn);

        // Симуляція серверного сокету та сервера
        mockSocket = new MockSocket();
        mockServer = new MockServer();
        clientHandler = new ClientHandler(mockSocket, mockServer);

        // Очікуємо, що клієнт надішле тестове повідомлення
        clientHandler.start(); // Викликаємо start() замість run()
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

    private class MockServer extends Server {
        @Override
        public void broadcastMessage(String message) {
            System.out.println(message);
        }
    }
}


