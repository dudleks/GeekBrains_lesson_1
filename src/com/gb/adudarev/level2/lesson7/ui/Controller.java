package com.gb.adudarev.level2.lesson7.ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

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
    @FXML
    public BorderPane authPanel;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField loginField;
    @FXML
    public BorderPane msgPanel;
    @FXML
    public Label userLoginNick;

    private static final String IP_ADDRESS = "localhost";
    public static final int PORT = 8765;
    private Socket socket;

    DataInputStream in;
    DataOutputStream out;

    private String nickName;
    private boolean authenticated;

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
        msgPanel.setVisible(authenticated);
        msgPanel.setManaged(authenticated);
        authPanel.setVisible(!authenticated);
        authPanel.setManaged(!authenticated);
        userLoginNick.setVisible(authenticated);
        userLoginNick.setManaged(authenticated);
        setAuthLabel();
        if (!authenticated) {
            nickName = "" + authenticated;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> loginField.requestFocus());
        setAuthenticated(false);
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


    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF(String.format("/auth %s %s", loginField.getText().trim().toLowerCase(), passwordField.getText().trim()));
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {

                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/authok")) {
                            nickName = str.split(" ", 2)[1];
                            setAuthenticated(true);
                            chatTextArea.appendText(str + "\n");
                            break;
                        }
                    }

                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/close")) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        chatTextArea.appendText(str + "\n");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAuthLabel() {
        Platform.runLater(() -> {
            userLoginNick.setText("Вы вошли как: " + nickName);
        });
    }
}
