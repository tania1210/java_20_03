package serverTest;

import org.junit.Before;
import org.junit.Test;

import server.ClientHandler;
import server.Server;

import static org.junit.Assert.*;

import java.net.Socket;

public class ServerTest {
    private Server server;

    @Before
    public void setUp() {
        server = new Server();
    }

    @Test
    public void testAddClient() {
        // Тест на додавання клієнта до списку активних клієнтів

        // Перед тестом кількість клієнтів має бути нульовою
        assertEquals(0, server.getClients().size());

        // Додамо фіктивного клієнта
        Socket dummyClientSocket1 = createDummyClientSocket();
        Socket dummyClientSocket2 = createDummyClientSocket();
        server.addClient(dummyClientSocket1);
        server.addClient(dummyClientSocket2);
        // Після додавання клієнта розмір списку має збільшитися на одиницю
        assertEquals(2, server.getClients().size());
    }

    @Test
    public void testRemoveClient() {
        ClientHandler dummyClientHandler = createDummyClientHandler();

        server.removeClient(dummyClientHandler);

        assertEquals(1, server.getClients().size());
    }

    private ClientHandler createDummyClientHandler() {
        return new ClientHandler(null, server);
    }

    private Socket createDummyClientSocket() {
        return new Socket();
    }
}



