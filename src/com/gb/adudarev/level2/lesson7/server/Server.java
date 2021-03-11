package com.gb.adudarev.level2.lesson7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class Server {

    private static int PORT = 8765;
    List<ClientHandler> clientList;
    ServerSocket serverSocket = null;
    Socket socket = null;
    private AuthService authService;


    public Server() {
        clientList = new Vector<>();
        authService = new SimpleAuthService();

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Сокет закрыт");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void broadCastMsg(ClientHandler sender, String msg) {
        String message = String.format("%s : %s", sender.getNickName(), msg);
        for (ClientHandler clientHandler : clientList) {
            clientHandler.sendMessage(message);

        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clientList.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clientList.remove(clientHandler);
    }


    public AuthService getAuthService() {
        return authService;
    }
}
