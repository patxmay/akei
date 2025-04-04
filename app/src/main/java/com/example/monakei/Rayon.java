package com.example.monakei;
import java.util.List;

public class Rayon {
    private String nom;
    private List<Produit> listeProduits;
    private List<Employe> listeEmployes;

    public Rayon(String nom, List<Produit> listeProduits, List<Employe> listeEmployes) {
        this.nom = nom;
        this.listeProduits = listeProduits;
        this.listeEmployes = listeEmployes;
    }

    public String getNom() { return nom; }
    public List<Produit> getListeProduits() { return listeProduits; }
    public List<Employe> getListeEmployes() { return listeEmployes; }

    public void setNom(String nom) { this.nom = nom; }
    public void setListeProduits(List<Produit> listeProduits) { this.listeProduits = listeProduits; }
    public void setListeEmployes(List<Employe> listeEmployes) { this.listeEmployes = listeEmployes; }
}