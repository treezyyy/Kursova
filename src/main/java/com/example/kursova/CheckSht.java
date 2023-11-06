package com.example.kursova;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
            DataBaseHandler dbHandler = new DataBaseHandler();
            String nomerok = avtoField.getText();
            try {
                String firstSht = dbHandler.getShtFromDB(nomerok);
                String secondSht = dbHandler.getShtSecondFromDB(nomerok);
                if((firstSht != null && !firstSht.isEmpty()) || (secondSht != null && !secondSht.isEmpty())){
                    greenLabel.setText("У вас найден штрафы: " + " ' " + firstSht + " ' " + " , " + "' " + secondSht + " ' ");
                    greenLabel.setTextFill(Color.RED);
                } else {
                    greenLabel.setText("Найдено штрафов: 0");
                    greenLabel.setTextFill(Color.GREEN);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    }

}