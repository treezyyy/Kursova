package com.example.kursova;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SitterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EmailEdit;

    @FXML
    private TextField MobileEdit;

    @FXML
    private Button SaveButton;

    @FXML
    private TextField WorkEdit;

    @FXML
    void initialize() {
        SaveButton.setOnAction(actionEvent -> {
            String email = EmailEdit.getText();
            String mobile = MobileEdit.getText();
            String work = WorkEdit.getText();
        });

    }

}
