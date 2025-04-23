package com.example.monakei;
public class Vehicule {
    private String nom;
    private String marque;
    private Integer capacite;
    private String dimensions;
    private String immat;
    private String carburant;
    private Integer kmActuel;

    public Vehicule(String nom, String marque, Integer capacite, String dimensions, String immat, String carburant, Integer kmActuel) {
        this.nom = nom;
        this.marque = marque;
        this.capacite = capacite;
        this.dimensions = dimensions;
        this.immat = immat;
        this.carburant = carburant;
        this.kmActuel = kmActuel;
    }

    public String getNom() { return nom; }
    public String getMarque() { return marque; }
    public Integer getCapacite() { return capacite; }
    public String getDimensions() { return dimensions; }
    public String getPlaqueImmat() { return immat; }
    public String getCarburant() { return carburant; }
    public Integer getKmActuel() { return kmActuel; }

    public void setNom(String nom) { this.nom = nom; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setCapacite(Integer capacite) { this.capacite = capacite; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public void setImmat(String plaqueImmatriculation) { this.immat = immat; }
    public void setCarburant(String carburant) { this.carburant = carburant; }
    public void setKmActuel(Integer kmActuel) { this.kmActuel = kmActuel; }
}