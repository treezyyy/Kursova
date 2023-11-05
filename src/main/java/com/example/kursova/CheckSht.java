package com.example.kursova;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckSht {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonCheck;

    @FXML
    private TextField avtoField;

    @FXML
    private Label greenLabel;

    @FXML
    void initialize() {
        ButtonCheck.setOnAction(actionEvent -> {
            greenLabel.setText("Найдено штрафов: 0");
        });
    }

}