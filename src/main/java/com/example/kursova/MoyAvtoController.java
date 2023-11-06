package com.example.kursova;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MoyAvtoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label buks;

    @FXML
    private Label colorcar;

    @FXML
    private Label kategory;

    @FXML
    private Label marka;

    @FXML
    private Label rashod;

    @FXML
    private Label vinLabel;

    @FXML
    private Label vu;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        int id = dbHandler.getIdFromDB(HelloController.login);
        String vinikvinik = dbHandler.getVinFromDB(id);
        String markamarka = dbHandler.getVinInMarkaFromDB(vinikvinik);
        String colorcolor = dbHandler.getVinColorFromDB(vinikvinik);
        String rashodrashod = dbHandler.getRashodFromDB(vinikvinik);
        String vuvu = dbHandler.getVuFromDB(vinikvinik);
        String katogorykatogory = dbHandler.getkatogoryFromDB(vinikvinik);
        String buksirbuksir = dbHandler.getbuksirFromDB(vinikvinik);
        System.out.println(buksirbuksir);
        System.out.println(katogorykatogory);
        System.out.println(vuvu);
        System.out.println(rashodrashod);
        System.out.println(colorcolor);
        System.out.println(markamarka);
        System.out.println(vinikvinik);

        marka.setText(markamarka);
        vinLabel.setText("VIN: " + vinikvinik);
        colorcar.setText("Цвет: " + colorcolor);
        rashod.setText("Расход: " + rashodrashod);
        vu.setText("В/У: " + vuvu);
        kategory.setText("Категория: " + katogorykatogory);
        buks.setText("Разрешение к буксировке: " + buksirbuksir);

    }

}