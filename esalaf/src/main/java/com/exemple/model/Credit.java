package com.exemple.model;

public class Credit {
    private int id_Credit ;
    private  String nom_Cli ;
    private  String nom_Prod ;
    private String date ;
    private String Qte ;
    private String etat;



    private String prix_credit;

    public Credit(int id_Credit, String date , String etat , String Qte , String nom_Cli , String nom_Prod ,String prix_credit ){
        this.id_Credit=id_Credit;
        this.date = date ;
        this.etat = etat ;
        this.Qte =Qte ;
        this.nom_Cli = nom_Cli ;
        this.nom_Prod = nom_Prod;
        this.prix_credit = prix_credit;

    }
    public int getId_Credit() {
        return id_Credit;
    }

    public void setId_Credit(int id_Credit) {
        this.id_Credit = id_Credit;
    }


    public String getNom_Cli() {
        return nom_Cli;
    }

    public void setNom_Cli( String nom_Cli) {
        this.nom_Cli = nom_Cli;
    }
    public String getNom_Prod() {
        return nom_Prod;
    }

    public void setNom_Prod(String nom_Prod) {
        this.nom_Prod = nom_Prod;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQte() {
        return Qte;
    }

    public void setQte(String qte) {
        Qte = qte;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    public String getPrix_credit() {
        return prix_credit;
    }

    public void setPrix_credit(String prix_credit) {
        this.prix_credit = prix_credit;
    }

}
