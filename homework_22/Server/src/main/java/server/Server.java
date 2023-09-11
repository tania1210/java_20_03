package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 12345; // Порт сервера
    private List<ClientHandler> clients = new ArrayList<>(); // Список підключених клієнтів

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущено на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новий клієнт підключився");
                addClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
    
    public void addClient(Socket clientSocket) {
        ClientHandler clientHandler = new ClientHandler(clientSocket, this);
        clients.add(clientHandler);
        clientHandler.start();
    }

    public void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public List<ClientHandler> getClients() {
        return clients;
    }

}


