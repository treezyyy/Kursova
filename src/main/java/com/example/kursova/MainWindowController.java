package com.example.kursova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.kursova.animations.Shake;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label firstInfo;

    @FXML
    private Button mayAvto;

    @FXML
    private Label secondinfo;

    @FXML
    private Label thirdinfo;

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
    private Label NameLabel;

    @FXML
    private ImageView IMAGE;

    @FXML
    private Label weather1;

    @FXML
    private Label CITY;

    @FXML
    private Label davlyak;
    @FXML
    private Label oshus;
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        DataBaseHandler dbHandler = new DataBaseHandler();
        int id = dbHandler.getIdFromDB(HelloController.login);
        System.out.println(HelloController.login);
        String name = dbHandler.getNameFromDB(id);
        NameLabel.setText(name);
        String phone = dbHandler.getMobileFromDB(id);
        MobilePhone.setText(phone);
        String email = dbHandler.getEmailFromDB(id);
        emailField.setText(email);
        String Info1 = dbHandler.getFirstInfoFromDB(1);
        String Info2 = dbHandler.getFirstInfoFromDB(2);
        String Info3 = dbHandler.getFirstInfoFromDB(3);
        firstInfo.setText(Info1);
        secondinfo.setText(Info2);
        thirdinfo.setText(Info3);
        String mali = dbHandler.getMaleFromDB(HelloController.login);
        Image image = new Image("D:\\JavaProject\\Kursova\\src\\main\\resources\\assets\\profile.png");
        if (mali.equals("Женский")) {
            IMAGE.setImage(image);
        }
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

        mayAvto.setOnAction(actionEvent -> {
            openNewScenes("moyAvto.fxml");

        });

        String getUserCity = CITY.getText().trim();
        System.out.println(getUserCity);
        if (!getUserCity.equals("")) { // Если данные не пустые
            // Получаем данные о погоде с сайта openweathermap
            String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=78922bde8b970c1d07d3ce24e7e2dfb5&units=metric");
            JSONObject obj = new JSONObject(output);
            weather1.setText("" + obj.getJSONObject("main").getDouble("temp"));
            davlyak.setText("" + obj.getJSONObject("main").getDouble("pressure"));
            oshus.setText("" + obj.getJSONObject("main").getDouble("feels_like"));
            System.out.println(output);

        }
    }


    public void openNewScenes(String Window) {
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

    public void openNewSceneses(String Window) {
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



    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Такой город был не найден!");
        }
        return content.toString();
    }
    }