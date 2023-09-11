package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private Socket socket;
    private Server server;
    private PrintWriter out;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            String clientName = "client-" + System.currentTimeMillis(); // Генерація імені клієнта

            server.broadcastMessage("[SERVER] " + clientName + " успішно підключився.");

            String message;
            while ((message = in.nextLine()) != null) {
                if (message.equals("-exit")) {
                    break;
                } else {
                    server.broadcastMessage(clientName + ": " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.removeClient(this);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}

