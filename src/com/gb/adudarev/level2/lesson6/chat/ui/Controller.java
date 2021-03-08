package com.gb.adudarev.level2.lesson6.chat.ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TextArea chatTextArea;
    @FXML
    public TextField inputField;
    @FXML
    public Button sendButton;

    private static final String IP_ADDRESS = "localhost";
    public static final int PORT = 8765;
    DataInputStream in;
    DataOutputStream out;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> inputField.requestFocus());
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/close")) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        chatTextArea.appendText("Сервер: > " + str + "\n");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageButton(ActionEvent actionEvent) {
        try {
            out.writeUTF(inputField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputField.clear();
        inputField.requestFocus();
    }

    public void pressEnterKey(ActionEvent actionEvent) {
        inputField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                try {
                    out.writeUTF(inputField.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputField.clear();
                inputField.requestFocus();
            }
        });
    }
}
