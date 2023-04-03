
package com.example.esalaf;

import com.exemple.model.Produit;
import com.exemple.model.ProduitDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {
    public Button ok;


    public Button update ;
    @FXML
    private TextField nom;

    @FXML
    private TextField pv;

    @FXML
    private TextField txt_idProduit;


    @FXML
    private TableView<Produit> mytab;

    @FXML
    private TableColumn<Produit, Long> col_id;

    @FXML
    private TableColumn<Produit, String> col_nom;

    @FXML
    private TableColumn<Produit, String> col_pv;


    @FXML
    protected void onSaveButtonClick(){

        Produit prod = new Produit(0, nom.getText() , pv.getText());

        try {
            ProduitDAO prodao = new ProduitDAO();

            prodao.save(prod);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }

    public static ObservableList<Produit> getDataProducts(){
        ProduitDAO prodao;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            prodao = new ProduitDAO();
            listfx.addAll(prodao.getAll());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));

        col_pv.setCellValueFactory(new PropertyValueFactory<>("pv"));


        mytab.setItems(getDataProducts());



    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }

    public void OnGoHomeClick() throws IOException {
        Main m = new Main();
        m.changeScene("Menu.fxml");

    }
    int index = -1;
    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        index = mytab.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        Produit selectedProduit = mytab.getSelectionModel().getSelectedItem();
        txt_idProduit.setText(String.valueOf(selectedProduit.getId_produit()));
        nom.setText(selectedProduit.getNom());
        pv.setText(String.valueOf(selectedProduit.getPv()));
    }



    @FXML
    protected void onDeleteButtonClick() {


        try {
            ProduitDAO prodao;
            prodao = new ProduitDAO();


            int myIndex = mytab.getSelectionModel().getSelectedIndex();


            int idValue = Integer.parseInt(String.valueOf(mytab.getItems().get(myIndex).getId_produit()));
            Produit prod = new Produit(idValue, nom.getText(), pv.getText());

            prodao.delete(prod);
            txt_idProduit.setText("");
            nom.setText("");
            pv.setText("");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UpdateTable();
    }


    @FXML
    protected void onEditButtonClick() {
        try {
            ProduitDAO prodao = new ProduitDAO();

            int selectedIndex = mytab.getSelectionModel().getSelectedIndex();
            if (selectedIndex == -1) {
                // Aucun produit n'a été sélectionné, rien à faire
                return;
            }

            Produit selectedProduit = mytab.getSelectionModel().getSelectedItem();
            int id = selectedProduit.getId_produit();
            String nom = this.nom.getText();
            String pv = this.pv.getText();

            // Met à jour l'objet produit avec les nouvelles valeurs
            selectedProduit.setNom(nom);
            selectedProduit.setPv(pv);

            // Met à jour le client dans la base de données
            prodao.update(selectedProduit);

            // Réinitialise les champs de texte
            this.txt_idProduit.setText("");
            this.nom.setText("");
            this.pv.setText("");

            // Met à jour la table
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}