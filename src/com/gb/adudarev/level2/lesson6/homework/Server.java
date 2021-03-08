package com.gb.adudarev.level2.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int PORT = 8430;

    public static void main(String[] args) {
        Socket socket = new Socket();
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            t.setDaemon(true);
            t.start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/close")) {
                    System.out.println("Клиент отключился");
                    break;
                }
                System.out.println("Клиент:> " + str);
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
}
