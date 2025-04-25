package com.example.monakei;

public class Produit {
    private Integer id_prod;
    private String nom;
    private String description;
    private double prix;
    private String dimensions;
    private double poids;

    public Produit(String nom, String description, double prix, String dimensions, double poids) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.dimensions = dimensions;
        this.poids = poids;
    }
    public Produit(Integer id_prod, String nom) {
        this.nom = nom;
        this.id_prod = id_prod;
    }
    public int getId() { return id_prod; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public double getPrix() { return prix; }
    public String getDimensions() { return dimensions; }
    public double getPoids() { return poids; }

    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public void setPoids(double poids) { this.poids = poids; }
}