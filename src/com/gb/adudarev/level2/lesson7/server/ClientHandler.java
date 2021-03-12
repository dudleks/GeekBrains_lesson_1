package com.gb.adudarev.level2.lesson7.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private DataInputStream in;
    private DataOutputStream out;


    private String nickName;

    public ClientHandler(Server server, Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {

                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] token = str.split("\\s");
                            String newNickName = server.getAuthService().getNickByLoginAndPassword(token[1], token[2]);

                            if (newNickName != null) {
                                nickName = newNickName;
                                sendMessage("/authok " + nickName);
                                server.subscribe(this);
                                System.out.println("Клиент " + nickName + " подключился");
                                break;
                            } else {
                                System.out.println("Неверный логин или пароль");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/close")) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        if (str.startsWith("/w")) {
                            String recipient = str.split(" ", 3)[1];
                            String text = str.split(" ", 3)[2];
                            if (recipient != null && text != null) {
                                server.privateMsg(this, recipient, text);
                            }
                        } else {
                            server.broadCastMsg(this, str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Клиент отключился");
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName() {
        return nickName;
    }

}
