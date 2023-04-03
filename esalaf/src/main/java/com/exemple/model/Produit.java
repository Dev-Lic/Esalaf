package com.exemple.model;

public class Produit {


    private int id_prod;
    private String nom;
    private String pv ;



    public String getNom_prod() {
        return nom;
    }

    public void setNom_prod(String nom_prod) {
        this.nom= nom_prod;
    }





    public Produit(){

    }

    public Produit (int id_Produit, String nom , String pv){
        this.id_prod = id_Produit ;
        this.nom=nom ;
        this.pv = pv ;

    }
    public int getId_produit() {
        return id_prod;
    }

    public void setId_produit(int id_produit) {
        this.id_prod = id_produit;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom= nom;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_prod+
                ", nom='" + nom+ "prix_vente :"+pv +"}";
    }
}

