package com.example.esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button logout;
    public Button client_page ;

    public Button produit_page ;

    public Button credit_page ;


    public void userLogOut(ActionEvent event) throws IOException {
         Main m = new Main();
        m.changeScene("login.fxml");

    }

    public void Click_Client(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("Client.fxml");
    }

    public void Click_Produit(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("Produit.fxml");
    }

    public void Click_Credit(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("Credit.fxml");

    }
}





