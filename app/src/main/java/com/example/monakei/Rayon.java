package com.example.monakei;
import java.util.ArrayList;
import java.util.List;

public class Rayon {
    private Integer id_ray;
    private String nom;
    private List<Produit> listeProduits;
    private List<Employe> listeEmployes;

    public Rayon(String nom, List<Produit> listeProduits, List<Employe> listeEmployes) {
        this.nom = nom;
        this.listeProduits = listeProduits;
        this.listeEmployes = listeEmployes;
    }

    public Rayon(Integer id_ray, String nom) {
        this.id_ray = id_ray;
        this.nom = nom;
        this.listeProduits = listeProduits;
        this.listeEmployes = listeEmployes;
    }
    public Rayon(String nom) {
        this.nom = nom;
        this.listeProduits = new ArrayList<>();
        this.listeEmployes = new ArrayList<>();
    }
    public int getId() { return id_ray; }
    public String getNom() { return nom; }
    public List<Produit> getListeProduits() { return listeProduits; }
    public List<Employe> getListeEmployes() { return listeEmployes; }

    public void setNom(String nom) { this.nom = nom; }
    public void setListeProduits(List<Produit> listeProduits) { this.listeProduits = listeProduits; }
    public void setListeEmployes(List<Employe> listeEmployes) { this.listeEmployes = listeEmployes; }
}