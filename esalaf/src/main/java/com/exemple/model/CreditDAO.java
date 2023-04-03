package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditDAO extends  BaseDAO<Credit>  {


    public CreditDAO() throws SQLException {
        super();
    }
    @Override
    public void save(Credit object) throws SQLException {

       String req = "insert into credit (date ,etat , Qte , nom_Cli , nom_Prod,prix_credit) values (? , ? , ? , ? , ?,? ) ;";


        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setString(1 , object.getDate());
        this.preparedStatement.setString(2 , object.getEtat());
        this.preparedStatement.setString(3 , object.getQte());
        this.preparedStatement.setString(4 , object.getNom_Cli());
        this.preparedStatement.setString(5 , object.getNom_Prod());
        this.preparedStatement.setString(6,object.getPrix_credit());
        this.preparedStatement.execute();


    }

    @Override
    public void update(Credit object) throws SQLException {

        String req = "UPDATE credit SET date=?, etat=? , Qte=? , nom_Cli=? , nom_Prod=? ,prix_credit = ?  WHERE id_Credit=?";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setString(1, object.getDate());
        this.preparedStatement.setString(2, object.getEtat());
        this.preparedStatement.setString(3, object.getQte());
        this.preparedStatement.setString(4, object.getNom_Cli());
        this.preparedStatement.setString(5, object.getNom_Prod());
        this.preparedStatement.setString(6, object.getPrix_credit());





        this.preparedStatement.execute();
    }

    @Override
    public void delete(Credit object) throws SQLException {
        String req = "DELETE FROM credit WHERE id_Credit = ?";
        this.preparedStatement = this.connection.prepareStatement(req);
        preparedStatement.setInt(1,object.getId_Credit());
        preparedStatement.execute();

    }

    @Override
    public Credit getOne(int id) throws SQLException {
        return null;
    }




    // mapping relation --> objet
    @Override
    public List<Credit> getAll() throws SQLException{

        List<Credit> mylist = new ArrayList<Credit>();
        String req = " select * from credit" ;

        this.statement = this.connection.createStatement();

        this.resultSet =  this.statement.executeQuery(req);

        while (this.resultSet.next()){

            mylist.add( new Credit(this.resultSet.getInt(1) , this.resultSet.getString(2), this.resultSet.getString(3),this.resultSet.getString(4) ,this.resultSet.getString(5),this.resultSet.getString(6),this.resultSet.getString(7)));

        }
          return mylist;
//    }


}


}

    // mapping objet --> relation
//    @Override
//    public void save(Credit object) throws SQLException {
//
//        String req = "insert into credit (date ,etat ,Qte,nom_Cli,nom_Prod ) values (? ,? , ?,?,?) ;";
//
//
//        this.preparedStatement = this.connection.prepareStatement(req);
//
//        this.preparedStatement.setString(1, object.getDate());
//        this.preparedStatement.setString(2, object.getEtat());
//        this.preparedStatement.setString(3, object.getQte());
//        this.preparedStatement.setString(4,object.getNom_Cli());
//        this.preparedStatement.setString(5,object.getNom_Prod());
//
//
//        this.preparedStatement.execute();
//
//    }
//
//    @Override
//    public void update(Credit object) throws SQLException {
//
//    }
//
//    @Override
//    public void delete(Credit object) throws SQLException {
//
//    }
//
//    @Override
//    public Credit getOne(Long id) throws SQLException {
//        return null;
//    }
//
//
//    // mapping relation --> objet
//    @Override
//    public List<Credit> getAll() throws SQLException {
//
//        List<Credit> mylist = new ArrayList<Credit>();
//        String req = " select * from credit";
//
//
//        this.statement = this.connection.createStatement();
//
//        this.resultSet = this.statement.executeQuery(req);
//
//        while (this.resultSet.next()) {
//
//            mylist.add(new Credit(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5),
//                    this.resultSet.getString(6)));
//
//        }
//
//        return mylist;
//    }
//
//
//    //Recuperation de la liste des produits
////    public List<String> getNomsProduits() throws SQLException {
////        List<String> nomsProduits = new ArrayList<>();
////
////        String query = "SELECT nom_prod FROM produit";
////
////        try (Statement statement = connection.createStatement();
////             ResultSet resultSet = statement.executeQuery(query)) {
////
////            while (resultSet.next()) {
////                String nomProduit = resultSet.getString("nom_prod");
////                //    nomsProduits.add(nomProduit);
////            }
////        }
////
////        return nomsProduits;
////    }
//
//
////            public List<String> getNomsProduits(Produit nom_prod) throws SQLException {
////                List<String> nomsProduits = new ArrayList<>();
////
////                    String query = "SELECT nom_prod FROM produit";
////
////
////
////                    // Parcourir les résultats et ajouter les noms de produits à la liste
////
////                this.statement = this.connection.createStatement();
////
////                this.resultSet =  this.statement.executeQuery(query);
////
////                while (this.resultSet.next()){
////
////                    nomsProduits.add();
////
////
////                }
////
////
////                return nomsProduits;
////            }
//
//
//}
//
//
//
