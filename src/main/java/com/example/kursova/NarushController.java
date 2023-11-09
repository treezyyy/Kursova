package com.example.kursova;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.kursova.animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
    private Label oshb;

    @FXML
    private Button reg;
    @FXML
    private Label thx;

    @FXML
    void initialize() {

        choise.getItems().addAll("Перекрытие движения", "Агрессивное поведение", "Другое");
        System.out.println(NomerValidator.isValidNomer(nomer.getText()));

        reg.setOnAction(actionEvent -> {
            if(NomerValidator.isValidNomer(nomer.getText())){
                System.out.println(NomerValidator.isValidNomer(nomer.getText()));
                thx.setTextFill(Color.GREEN);
                thx.setText("Благодарим за активную общественную позицию!");
            } else {
                System.out.println(NomerValidator.isValidNomer(nomer.getText()));
                thx.setTextFill(Color.RED);
                thx.setText("Укажите верный номер автомобиля");
            }
        });




    }

}
