package com.example.kursova;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Text MainText;

    @FXML
    private TextField PasswordFields;

    @FXML
    private Button RegistrationButton;

    @FXML
    private TextField SignName;

    @FXML
    private TextField SignSurname;

    @FXML
    void initialize(){


        RegistrationButton.setOnAction(actionEvent -> {

            signUpNewUser();


        });

        BackButton.setOnAction(actionEvent -> {
            openNewScene("hello-veiw.fxml");
        });
    }

    private void signUpNewUser(){
        DataBaseHandler dbHandler = new DataBaseHandler();
        String userName = SignName.getText();
        String login = SignSurname.getText();
        String password = PasswordFields.getText();
        String gender = "";
        if (CheckBoxMen.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(userName,login,password,gender);

        try {
            dbHandler.signUpUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void openNewScene(String Window){
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
        stage.showAndWait();
    }

}