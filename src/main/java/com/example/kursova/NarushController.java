package com.example.kursova;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NarushController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choise;

    @FXML
    private TextField nomer;

    @FXML
    private TextField podrobnee;

    @FXML
    private Button reg;
    @FXML
    private Label thx;

    @FXML
    void initialize() {

        choise.getItems().addAll("Перекрытие движения", "Агрессивное поведение", "Другое");

        reg.setOnAction(actionEvent -> {
           thx.setText("Благодарим за активную общественную позицию!");
        });


    }

}
