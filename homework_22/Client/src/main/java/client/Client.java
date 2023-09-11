package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(Socket mockSocket) {
	}

	public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Замініть "server_ip" і server_port на IP-адресу та порт сервера

            // Потік для відправки повідомлень на сервер
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Потік для отримання повідомлень від сервера
            Scanner in = new Scanner(socket.getInputStream());

            // Потік для введення користувача
            Scanner userInput = new Scanner(System.in);

            String message;
            while (true) {
                sendMessage();
                message = userInput.nextLine();
                out.println(message);

                if (message.equals("-exit")) {
                    break;
                }

                String response = in.nextLine();
                System.out.println("Повідомлення від сервера: " + response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static boolean sendMessage() {
		System.out.print("Ви підключились до сервера.\nВведіть повідомлення або команду (-exit для виходу): ");
		return true;
	}
    
    
}

