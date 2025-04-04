package com.example.monakei;

public class Employe {
    private String nom;
    private String prenom;
    private String specialisation;
    private Magasin magasin;

    public Employe(String nom, String prenom, String specialisation, Magasin magasin) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialisation = specialisation;
        this.magasin = magasin;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getSpecialisation() { return specialisation; }
    public Magasin getMagasin() { return magasin; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setSpecialisation(String specialisation) { this.specialisation = specialisation; }
    public void setMagasin(Magasin magasin) { this.magasin = magasin; }
}