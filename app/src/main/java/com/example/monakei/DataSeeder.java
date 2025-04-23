package com.example.monakei;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import android.content.ContentValues;
import android.database.Cursor;

public class DataSeeder {

    // ----------------------------------
    // Magasins
    // ----------------------------------
    public static void inserrDatas(SQLiteDatabase db) {
        //-------------------------------------------------
        // on cree 2 magasins
        //-------------------------------------------------
        ArrayList<Magasin> magasins = new ArrayList<>();
        magasins.add(new Magasin("Akei Marseille", "15 rue Paradis"));
        magasins.add(new Magasin("Akei Toulouse", "3 allée Jean Jaurès"));

        for (Magasin m : magasins) {
            ContentValues values = new ContentValues();
            values.put("nom", m.getNom());
            values.put("adresse", m.getAdresse());
            db.insert("magasin", null, values);
        }

        //-------------------------------------------------
        // on cree 2 rayons qu'on ajoute à chaque magasin
        //-------------------------------------------------
        ArrayList<Rayon> rayons;
        rayons = new ArrayList<>();
        rayons.add(new Rayon("Salle à manger"));
        rayons.add(new Rayon("Cuisine"));
        for (Rayon r : rayons) {
            ContentValues valuesRayon = new ContentValues();
            valuesRayon.put("nom", r.getNom());
            valuesRayon.put("id_mag", magasinId("Akei Marseille", db));
            db.insert("rayon", null, valuesRayon);
        }
        rayons.add(new Rayon("Bureau"));
        rayons.add(new Rayon("Chambre"));
        for (Rayon r : rayons) {
            ContentValues valuesRayon = new ContentValues();
            valuesRayon.put("nom", r.getNom());
            valuesRayon.put("id_mag", magasinId("Akei Toulouse", db));
            db.insert("rayon", null, valuesRayon);
        }

        //-------------------------------------------------
        // on cree 2 produits dans chaque rayon du magasin
        //-------------------------------------------------
        ArrayList<Produit> produits = new ArrayList<>();

        produits.add(new Produit("Canape", "Canapé 3 places + méridienne", 600, "250x60x25", 100));
        produits.add(new Produit("Table basse", "Table de salon", 100, "600x60x15", 80));
        for (Produit p : produits) {
            ContentValues valuesProduit = new ContentValues();
            valuesProduit.put("nom", p.getNom());
            valuesProduit.put("description", p.getDescription());
            valuesProduit.put("prix", p.getPrix());
            valuesProduit.put("dimension", p.getDimensions());
            valuesProduit.put("id_ray", rayonId("Salle à manger", db));
            db.insert("produit", null, valuesProduit);
        }
        produits = new ArrayList<>();
        produits.add(new Produit("Four", "Four à pyrolise", 550, "70x60x25", 80));
        produits.add(new Produit("Evier", "Evier inox", 100, "20x60x15", 25));
        for (Produit p : produits) {
            ContentValues valuesProduit = new ContentValues();
            valuesProduit.put("nom", p.getNom());
            valuesProduit.put("description", p.getDescription());
            valuesProduit.put("prix", p.getPrix());
            valuesProduit.put("dimension", p.getDimensions());
            valuesProduit.put("id_ray", rayonId("Cuisine", db));
            db.insert("produit", null, valuesProduit);
        }

        //-------------------------------------------------
        // on cree 2 vehicules qu'on ajoute à chaque magasin
        //-------------------------------------------------
        ArrayList<Vehicule> vehicles;
        ContentValues valuesVehicle;
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicule("Renault", "Kangoo", 5, "4x2x2", "AS-923-CD", "Essence", 250));
        vehicles.add(new Vehicule("Citroen", "C3", 3, "4x2x2", "AB-123-CD", "Diesel", 100));
        for (Vehicule v : vehicles) {
            valuesVehicle = new ContentValues();
            valuesVehicle.put("nom", v.getNom());
            valuesVehicle.put("marque", v.getMarque());
            valuesVehicle.put("capacite", v.getCapacite());
            valuesVehicle.put("dimension", v.getDimensions());
            valuesVehicle.put("immat", v.getPlaqueImmat());
            valuesVehicle.put("carburant", v.getCarburant());
            valuesVehicle.put("kmactuel", v.getKmActuel());
            valuesVehicle.put("id_mag", magasinId("Akei Marseille", db));
            db.insert("vehicule", null, valuesVehicle);
        }
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicule("BMW", "TOROUI", 2, "5x6x2", "XX-923-CD", "Essence", 105600));
        vehicles.add(new Vehicule("Audi", "Az500", 3, "4x3x2", "DF-983-CD", "Diesel", 78100));
        for (Vehicule v : vehicles) {
            valuesVehicle = new ContentValues();
            valuesVehicle.put("nom", v.getNom());
            valuesVehicle.put("marque", v.getMarque());
            valuesVehicle.put("capacite", v.getCapacite());
            valuesVehicle.put("dimension", v.getDimensions());
            valuesVehicle.put("immat", v.getPlaqueImmat());
            valuesVehicle.put("carburant", v.getCarburant());
            valuesVehicle.put("kmactuel", v.getKmActuel());
            valuesVehicle.put("id_mag", magasinId("Akei Toulouse", db));
            db.insert("vehicule", null, valuesVehicle);
        }

        //-------------------------------------------------
        // on cree des employes
        //-------------------------------------------------
        ArrayList<Employe> employes;
        ContentValues valuesEmploye;

        employes = new ArrayList<>();
        employes.add(new Employe("IBAR","Jacques","jacques.ibar@gmail.com"));
        employes.add(new Employe("CAYROLLE","YON","yon.cayrolle@gmail.com"));
        for (Employe e : employes) {
            valuesEmploye = new ContentValues();
            valuesEmploye.put("nom", e.getNom());
            valuesEmploye.put("prenom", e.getPrenom());
            valuesEmploye.put("email", e.getEmail());
            valuesEmploye.put("id_mag", magasinId("Akei Marseille", db));
            valuesEmploye.put("id_ray", rayonId("Salle à manger", db));
            db.insert("employe", null, valuesEmploye);
        }
        employes = new ArrayList<>();
        employes.add(new Employe("DUPOND","Jacqueline","j.dupond@free.fr"));
        employes.add(new Employe("DURAND","Georges","g?durand@hotmail.com"));
        for (Employe e : employes) {
            valuesEmploye = new ContentValues();
            valuesEmploye.put("nom", e.getNom());
            valuesEmploye.put("prenom", e.getPrenom());
            valuesEmploye.put("email", e.getEmail());
            valuesEmploye.put("id_mag", magasinId("Akei Marseille", db));
            valuesEmploye.put("id_ray", rayonId("Cuisine", db));
            db.insert("employe", null, valuesEmploye);
        }
    }

    private static long magasinId(String nomMagasin, SQLiteDatabase db) {
        long magasinId = 0;
        Cursor cursor = db.rawQuery("SELECT id_mag FROM magasin WHERE nom = ?", new String[]{nomMagasin});
        if (cursor.moveToFirst()) {
            magasinId = cursor.getInt(0); // récupère l'id du magasin
        }
        return magasinId;
    }
    private static long rayonId(String nomRayon, SQLiteDatabase db){
        long rayonId = 0;
        Cursor cursor = db.rawQuery("SELECT id_ray FROM rayon WHERE nom = ?", new String[]{nomRayon});
        if (cursor.moveToFirst()) {
            rayonId = cursor.getInt(0); // récupère l'id du magasin
        }
        return rayonId;
    }
}

