package com.example.kursova;

import com.example.kursova.animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SignAppController {

    @FXML
    private Button BackButton;

    @FXML
    private CheckBox CheckBoxMen;

    @FXML
    private CheckBox CheckBoxWomen;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField MobilePhone;

    @FXML
    private TextField PasswordFields;

    @FXML
    private Button RegistrationButton;

    @FXML
    private TextField SignName;

    @FXML
    private TextField SignSurname;

    @FXML
    private TextField vin;

    @FXML
    private Text registration;



    @FXML
    void initialize(){
        Font bebas = null;
        Font bebas20 = null;
        try {
            bebas = Font.loadFont(new FileInputStream(new File("D:\\JavaProject\\Kursova\\src\\main\\resources\\com\\example\\kursova\\fonts\\BebasNeue Bold.otf")), 70);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            bebas20 = Font.loadFont(new FileInputStream(new File("D:\\JavaProject\\Kursova\\src\\main\\resources\\com\\example\\kursova\\fonts\\BebasNeue Bold.otf")), 20);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        registration.setFont(bebas);
        RegistrationButton.setFont(bebas20);

        BackButton.setFont(bebas20);


        RegistrationButton.setOnAction(actionEvent -> {

            signUpNewUser();


        });

        BackButton.setOnAction(actionEvent -> {
            openNewScene1("hello-view.fxml");
        });
    }

    private void signUpNewUser(){
        DataBaseHandler dbHandler = new DataBaseHandler();
        String userName = SignName.getText();
        String login = SignSurname.getText();
        String password = PasswordFields.getText();
        String phone = MobilePhone.getText();
        String email = EmailField.getText();
        String vinn = vin.getText();
        String gender = "";
        if (CheckBoxMen.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";


        if(PhoneValidator.isValidEmail(phone)){
            User user = new User(userName,login,password,gender,phone,email,vinn);
            try {
                dbHandler.signUpUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            Shake PhoneAnim = new Shake(MobilePhone);
            PhoneAnim.playAnim();
        }



    }
    public void openNewScene1(String Window){
        BackButton.getScene().getWindow().hide();

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