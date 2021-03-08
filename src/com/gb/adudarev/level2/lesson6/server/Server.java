package com.gb.adudarev.level2.lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Server {

    private static int PORT = 8765;
    List<ClientHandler> clientList;
    ServerSocket serverSocket = null;
    Socket socket = null;


    public Server() {
        clientList = new Vector<>();

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                clientList.add(new ClientHandler(this, socket));
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

    public void broadCastMsg(String msg) {
        for (ClientHandler clientHandler : clientList) {
            clientHandler.sendMessage(msg);

        }
    }
}
