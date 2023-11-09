package com.example.kursova;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.kursova.animations.Shake;
import javafx.scene.control.Label;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Button AufButton;

    @FXML
    private Text AutText;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private TextField PasswordField;

    static String login;

    @FXML
    void initialize() {
        AufButton.setOnAction(actionEvent -> {
            String loginText = LoginField.getText().trim();
            login = loginText;
            String loginPassword = PasswordField.getText().trim();
            if(loginText.equals("balandin") && loginPassword.equals("123")){
                openNewScene("adminPanel.fxml");
            } else{if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("login and password is empty");}
        });
        Font myFont = null;
        Font myFont1 = null;
        Font myFont2 = null;

        try {
            myFont2 = Font.loadFont(new FileInputStream(new File("D:\\JavaProject\\Kursova\\src\\main\\resources\\com\\example\\kursova\\fonts\\BebasNeue Book.otf")), 70);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myFont = Font.loadFont(new FileInputStream(new File("src/main/resources/com/example/kursova/fonts/Rubik Mono One Regular.ttf")), 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myFont1 = Font.loadFont(new FileInputStream(new File("src/main/resources/com/example/kursova/fonts/ActayCondensed-Thin.otf")), 37);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        LoginButton.setFont(myFont);
        PasswordField.setFont(myFont);
        LoginField.setFont(myFont);
        AufButton.setFont(myFont);

        AutText.setFont(myFont2);

        LoginButton.setOnAction(actionEvent -> {
            openNewScene("SignApp.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;

        try {
            while (result.next()){
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(counter >= 1){
            openNewScene("app.fxml");

        } else {
            Shake userLoginAnim = new Shake(LoginField);
            Shake userPassAnim = new Shake(PasswordField);
            userPassAnim.playAnim();
            userLoginAnim.playAnim();
        }
    }

    public void openNewScene(String Window){
        LoginButton.getScene().getWindow().hide();

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