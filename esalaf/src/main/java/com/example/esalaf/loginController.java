package com.example.esalaf;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
public class loginController {

    public loginController() {

    }

    @FXML
    private Button login;
    @FXML
    private Label wronglogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password  ;



    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();
        if(username.getText().toString().equals("Wijdane") && password.getText().toString().equals("1234")) {
            wronglogin.setText("Success!");

            m.changeScene("Menu.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wronglogin.setText("Please enter your data.");
        }


        else {
            wronglogin.setText("Wrong username or password!");
        }
    }


    public void userRegister(ActionEvent event) throws IOException {
        Main m = new Main();
            m.changeScene("Register.fxml");



}
}