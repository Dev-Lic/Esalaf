package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProduitDAO extends BaseDAO<Produit>{
    public ProduitDAO() throws SQLException {
        super();
    }

    @Override
    public void save(Produit object) throws SQLException {
        String req = "insert into produit (nom_prod ,pv) values (? , ?) ;";
        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1 , object.getNom());
        this.preparedStatement.setString(2 , object.getPv());
        this.preparedStatement.execute();

    }


    @Override
    public void update(Produit object) throws SQLException {

        String req = "UPDATE produit SET nom_prod=?, pv=? WHERE id_prod=?";

        this.preparedStatement = this.connection.prepareStatement(req);

        this.preparedStatement.setString(1, object.getNom_prod());
        this.preparedStatement.setString(2, object.getPv());
        this.preparedStatement.setInt(3, object.getId_produit());

        this.preparedStatement.execute();
    }

    @Override
    public void delete(Produit object) throws SQLException {
        String request = "DELETE FROM produit WHERE id_prod = ?";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setInt(1 , object.getId_produit());

        this.preparedStatement.execute();
    }

    @Override
    public Produit getOne(int id)  {
        return null;
    }

    @Override

    public List<Produit> getAll() throws SQLException{

        List<Produit> mylist = new ArrayList<Produit>();
        String req = " select * from produit" ;


        this.statement = this.connection.createStatement();

        this.resultSet =  this.statement.executeQuery(req);

        while (this.resultSet.next()){

            mylist.add( new Produit(this.resultSet.getInt(1) , this.resultSet.getString(2),
                    this.resultSet.getString(3)));


        }

        return mylist;
    }
}




