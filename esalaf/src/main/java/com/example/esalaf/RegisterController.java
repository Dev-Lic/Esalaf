package com.example.esalaf;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RegisterController {


    public void userRegister(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }

}
