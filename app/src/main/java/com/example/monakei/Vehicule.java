package com.example.monakei;
public class Vehicule {
    private String nom;
    private String marque;
    private String capacite;
    private String dimensions;
    private String plaqueImmatriculation;
    private String carburant;
    private int kmActuel;

    public Vehicule(String nom, String marque, String capacite, String dimensions, String plaqueImmatriculation, String carburant, int kmActuel) {
        this.nom = nom;
        this.marque = marque;
        this.capacite = capacite;
        this.dimensions = dimensions;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.carburant = carburant;
        this.kmActuel = kmActuel;
    }

    public String getNom() { return nom; }
    public String getMarque() { return marque; }
    public String getCapacite() { return capacite; }
    public String getDimensions() { return dimensions; }
    public String getPlaqueImmatriculation() { return plaqueImmatriculation; }
    public String getCarburant() { return carburant; }
    public int getKmActuel() { return kmActuel; }

    public void setNom(String nom) { this.nom = nom; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setCapacite(String capacite) { this.capacite = capacite; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public void setPlaqueImmatriculation(String plaqueImmatriculation) { this.plaqueImmatriculation = plaqueImmatriculation; }
    public void setCarburant(String carburant) { this.carburant = carburant; }
    public void setKmActuel(int kmActuel) { this.kmActuel = kmActuel; }
}