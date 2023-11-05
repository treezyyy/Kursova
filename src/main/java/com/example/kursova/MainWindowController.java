package com.example.kursova;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EditButton;

    @FXML
    private Label MobilePhone;

    @FXML
    private Label WorkPhone;

    @FXML
    private Label emailField;

    @FXML
    private Button checkShter;

    @FXML
    private Button close;

    @FXML
    private Button Otmetit;

    @FXML
    void initialize() {
        EditButton.setOnAction(actionEvent -> {
            openNewScenes("sitter.fxml");

        });


        close.setOnAction(actionEvent -> {
            openNewSceneses("hello-view.fxml");

        });

        Otmetit.setOnAction(actionEvent -> {
            openNewScenes("Narush.fxml");

        });

        checkShter.setOnAction(actionEvent -> {
            openNewScenes("checkSht.fxml");

        });

    }



    public void openNewScenes(String Window){
        EditButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(Window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Parent root = loader.getRoot();

        Stage stage = new Stage();
        Scene scene = new Scene(root); // Создайте объект Scene и передайте корневой элемент
        stage.setScene(scene); // Установите сцену на этапе
        stage.show();
    }

    public void openNewSceneses(String Window){
        EditButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(Window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Parent root = loader.getRoot();

        Stage stage = new Stage();
        Scene scene = new Scene(root); // Создайте объект Scene и передайте корневой элемент
        stage.setScene(scene); // Установите сцену на этапе
        stage.show();
    }
}