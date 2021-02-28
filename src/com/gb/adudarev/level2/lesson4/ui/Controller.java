package com.gb.adudarev.level2.lesson4.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TextArea chatTextArea;
    @FXML
    public TextField inputField;
    @FXML
    public Button sendButton;

    public void sendMessageButton(ActionEvent actionEvent) {
        chatTextArea.appendText("Вы: > " + inputField.getText() + "\n");
        inputField.clear();
        inputField.requestFocus();
    }


    public void pressEnterKey(ActionEvent actionEvent) {
        inputField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    chatTextArea.appendText("Вы: > " + inputField.getText() + "\n");
                    inputField.clear();
                    inputField.requestFocus();
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      Platform.runLater(() -> inputField.requestFocus());
    }
}
