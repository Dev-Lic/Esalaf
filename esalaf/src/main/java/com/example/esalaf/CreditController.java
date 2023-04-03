package com.example.esalaf;

import com.exemple.model.Credit;
import com.exemple.model.CreditDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreditController implements Initializable {
@FXML
public Button home ;

@FXML
public Button ok ;
@FXML
public Button delete ;
@FXML
public Button update ;
    @FXML
    private TableView<Credit> mytab;

    @FXML
    private TableColumn<Credit, Long> col_id;

    @FXML
    private TableColumn<Credit, String> col_Qte;

    @FXML
    private TableColumn<Credit, String> col_date;
    @FXML
    private TableColumn<Credit, String> col_etat;

    @FXML
    private TableColumn<Credit, String> col_nomCli;

    @FXML
    private TableColumn<Credit, String> col_nomProd;

    @FXML
    private TableColumn<Credit,String> col_prixCredit ;


    @FXML
    private TextField txt_idCredit;

    @FXML
    private TextField txt_date ;

    @FXML
    private TextField txt_Qte ;
    @FXML
    private TextField txt_etat;

    @FXML
    private TextField txt_nomCli;

    @FXML
    private TextField txt_nomProd ;

    @FXML
    private TextField txt_prixCredit ;

    public void OnGoHomeClick() throws IOException {
        Main m = new Main();
        m.changeScene("Menu.fxml");

    }

    @FXML
    protected void onSaveButtonClick(){

        Credit cred = new Credit(0,txt_date.getText(),txt_etat.getText(), txt_Qte.getText(),txt_nomCli.getText(), txt_nomProd.getText(),txt_prixCredit.getText());

        try {
            CreditDAO credoa = new CreditDAO();

            credoa.save(cred);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

      UpdateTable();

    }

    private void UpdateTable() {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_Credit"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        col_Qte.setCellValueFactory(new PropertyValueFactory<>("Qte"));
        col_nomCli.setCellValueFactory(new PropertyValueFactory<>("nom_Cli"));
        col_nomProd.setCellValueFactory(new PropertyValueFactory<>("nom_Prod"));
        col_prixCredit.setCellValueFactory(new PropertyValueFactory<>("prix_credit"));

        mytab.setItems(getDataProducts());
    }

    public static ObservableList<Credit> getDataProducts() {
        CreditDAO credao = null;
        ObservableList<Credit> listfx;
        try {

            credao = new CreditDAO();
            listfx = FXCollections.observableArrayList();

            listfx.addAll(credao.getAll());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listfx;
    }

    public void onEditButtonClick(ActionEvent event) {
        try {
            CreditDAO credao= new CreditDAO();

            int selectedIndex = mytab.getSelectionModel().getSelectedIndex();
            if (selectedIndex == -1) {
                // Aucun credit n'a été sélectionné, rien à faire
                return;
            }

            Credit selectedCredit = mytab.getSelectionModel().getSelectedItem();
            int id = selectedCredit.getId_Credit();
            String date = this.col_date.getText();
            String etat = this.col_etat.getText();
            String Qte = this.col_Qte.getText();
            String nom_Cli = this.col_nomCli.getText();
            String nom_Prod = this.col_nomProd.getText();
            String prix_Credit = this.col_prixCredit.getText();


            // Met à jour l'objet client avec les nouvelles valeurs
            selectedCredit.setDate(date);
            selectedCredit.setEtat(etat);
            selectedCredit.setQte(Qte);
            selectedCredit.setNom_Cli(nom_Cli);
            selectedCredit.setNom_Prod(nom_Prod);
            selectedCredit.setPrix_credit(prix_Credit);

            // Met à jour le client dans la base de données
           credao.update(selectedCredit);

            // Réinitialise les champs de texte
            this.col_date.setText("");
            this.col_etat.setText("");
            this.col_Qte.setText("");
            this.col_nomCli.setText("");
            this.col_nomProd.setText("");
            this.col_prixCredit.setText("");
            // Met à jour la table
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    public void onDeleteButtonClick() {
        try {
            CreditDAO credao;
            credao = new CreditDAO();


            int myIndex = mytab.getSelectionModel().getSelectedIndex();

            int idValue = Integer.parseInt(String.valueOf(mytab.getItems().get(myIndex).getId_Credit()));
            Credit cre = new Credit(idValue, col_date.getText(), col_etat.getText(),col_Qte.getText(),col_nomCli.getText(),col_nomProd.getText(),txt_prixCredit.getText());

            credao.delete(cre);
            col_date.setText("");
            col_etat.setText("");
            col_Qte.setText("");
            col_nomCli.setText("");
            col_nomProd.setText("");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UpdateTable();
    }
    int index = -1;
    public void getSelected(MouseEvent mouseEvent) {

        index = mytab.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        Credit selectedCredit = mytab.getSelectionModel().getSelectedItem();
        txt_idCredit.setText(String.valueOf(selectedCredit.getId_Credit()));
        txt_date.setText(selectedCredit.getDate());
        txt_etat.setText(selectedCredit.getEtat());
        txt_Qte.setText(selectedCredit.getQte());

        txt_nomCli.setText(selectedCredit.getNom_Cli());
        txt_nomProd.setText(selectedCredit.getNom_Prod());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }


//


    }

