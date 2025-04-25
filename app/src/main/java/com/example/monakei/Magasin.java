package com.example.monakei;
import java.util.List;
import  java.util.ArrayList;

public class Magasin {
    private Integer id_mag;
    private String nom;
    private String adresse;
    private List<Rayon> listeRayons;
    private List<Vehicule> listeVehicules;
    private List<Employe> listeEmployes;

    public Magasin(String nom, String adresse, List<Rayon> listeRayons, List<Vehicule> listeVehicules, List<Employe> listeEmployes) {
        this.nom = nom;
        this.adresse = adresse;
        this.listeRayons = listeRayons;
        this.listeVehicules = listeVehicules;
        this.listeEmployes = listeEmployes;
    }

    public Magasin(Integer id_mag, String nom) {
        this.id_mag = id_mag;
        this.nom = nom;
    }

    // New constructor
    public Magasin(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listeRayons = new ArrayList<>();
        this.listeVehicules = new ArrayList<>();
        this.listeEmployes = new ArrayList<>();
    }
    public int getId() { return id_mag; }

    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public List<Rayon> getListeRayons() { return listeRayons; }
    public List<Vehicule> getListeVehicules() { return listeVehicules; }
    public List<Employe> getListeEmployes() { return listeEmployes; }

    public void setNom(String nom) { this.nom = nom; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setListeRayons(List<Rayon> listeRayons) { this.listeRayons = listeRayons; }
    public void setListeVehicules(List<Vehicule> listeVehicules) { this.listeVehicules = listeVehicules; }
    public void setListeEmployes(List<Employe> listeEmployes) { this.listeEmployes = listeEmployes; }

    @Override
    public String toString() {
        return nom; // Retourner le nom du magasin pour l'affichage
    }
    public void ajouterRayon(Rayon r) {
        // cette fonction permet de garder le controle dans la classe Magasin
        // // sur ce qu’on peut ajouter ou non (ex. verifier qu’il n’y a pas de doublon, etc.).
        listeRayons.add(r);
    }
}