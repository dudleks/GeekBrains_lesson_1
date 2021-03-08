package com.gb.adudarev.level2.lesson6.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String IP_ADDRESS = "localhost";
    static final int PORT = 8430;

    public static void main(String[] args) {
        Socket socket = new Socket();
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Подключаемся к серверу");
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
                System.out.println("Сервер:> " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
