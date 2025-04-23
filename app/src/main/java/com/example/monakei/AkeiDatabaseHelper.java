package com.example.monakei;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context; // Import added
import android.database.Cursor;
import android.util.Log;

public class AkeiDatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "akei.db";
    private static final int DATABASE_VERSION = 6;

    public AkeiDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création des tables
        db.execSQL("CREATE TABLE magasin(" +
                  " id_mag INTEGER PRIMARY KEY AUTOINCREMENT," +
                  " nom TEXT," +
                  " adresse TEXT," +
                  " cp TEXT," +
                  " ville TEXT," +
                  " tel TEXT);");

        db.execSQL("CREATE TABLE rayon(" +
                   " id_ray INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " nom TEXT," +
                   " id_mag INTEGER NOT NULL," +
                   " FOREIGN KEY(id_mag) REFERENCES magasin(id_mag));");

        db.execSQL("CREATE TABLE produit(" +
                   " id_prod INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " nom TEXT," +
                   " description TEXT," +
                   " prix NUMERIC," +
                   " dimension TEXT," +
                   " poids REAL," +
                   " id_ray INTEGER NOT NULL," +
                   " FOREIGN KEY(id_ray) REFERENCES rayon(id_ray));");

        db.execSQL("CREATE TABLE employe(" +
                   " id_emp INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " nom TEXT," +
                   " prenom TEXT," +
                   " email TEXT," +
                   " id_ray INTEGER NOT NULL," +
                   " id_mag INTEGER NOT NULL," +
                   " FOREIGN KEY(id_ray) REFERENCES rayon(id_ray)," +
                   " FOREIGN KEY(id_mag) REFERENCES magasin(id_mag));");

        db.execSQL("CREATE TABLE vehicule(" +
                   " id_veh INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " nom TEXT," +
                   " marque TEXT," +
                   " immat TEXT," +
                   " carburant TEXT," +
                   " dimension TEXT," +
                   " capacite INTEGER," +
                   " kmactuel INTEGER," +
                   " id_mag INTEGER NOT NULL," +
                   " FOREIGN KEY(id_mag) REFERENCES magasin(id_mag));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Supprimer et recréer si version change
        db.execSQL("DROP TABLE IF EXISTS vehicule");
        db.execSQL("DROP TABLE IF EXISTS employe");
        db.execSQL("DROP TABLE IF EXISTS produit");
        db.execSQL("DROP TABLE IF EXISTS rayon");
        db.execSQL("DROP TABLE IF EXISTS magasin");
        onCreate(db);
    }

    public void deleteData(SQLiteDatabase db) {
        // Supprimer et recréer si version change
        db.execSQL("DELETE FROM vehicule");
        db.execSQL("DELETE FROM employe");
        db.execSQL("DELETE FROM magasin");
        db.execSQL("DELETE FROM rayon");
        db.execSQL("DELETE FROM produit");
    }
    public Cursor getAllRayons() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM rayons", null);
    }
    public void InsertData(SQLiteDatabase db){
        Cursor cursor;
        ContentValues values = new ContentValues();
        int magasinId = -1;
        int rayonId = -1;

        // db.execSQL("INSERT INTO
        // ------------------------
        // magasin
        // ------------------------
        values.put("nom", "Akei Paris");
        values.put("adresse", "12 rue de Paris");
        db.insert("magasin", null, values);
        Log.d("DEBUG", "Magasin Akei PAris inséré" );

        values.put("nom", "Akei Anglet");
        values.put("adresse", "Ametzondo");
        db.insert("magasin", null, values);
        Log.d("DEBUG", "Magasin Anglet inséré" );

        // ------------------------
        // rayon
        // ------------------------
        String nomMagasin = "Akei Paris";
        cursor = db.rawQuery("SELECT id_mag FROM magasin WHERE nom = ?", new String[]{nomMagasin});
        if (cursor.moveToFirst()) {
            magasinId = cursor.getInt(0); // récupère l'id du magasin
        }
        cursor.close();
        if (magasinId != -1) {
            ContentValues value_rayon = new ContentValues();
            value_rayon.put("nom", "Salon");
            value_rayon.put("id_mag", magasinId);
            db.insert("rayon", null, value_rayon);
            Log.d("DEBUG", "Rayon inséré avec l'id: " );
        }

        // ------------------------
        // produit
        // ------------------------
        String nomRayon = "Salon";
        cursor = db.rawQuery("SELECT id_ray FROM rayon WHERE nom = ?", new String[]{nomRayon});
        if (cursor.moveToFirst()) {
            rayonId = cursor.getInt(0); // récupère l'id du rayon
        }
        cursor.close();
        if (rayonId != -1) {
            ContentValues value_produit = new ContentValues();
            value_produit.put("nom", "canape");
            value_produit.put("description", "Description canape");
            value_produit.put("prix", 600);
            value_produit.put("id_ray", rayonId);
            db.insert("produit", null, value_produit);
            Log.d("DEBUG", "produit inséré avec l'id: " );

            value_produit.put("nom", "tablechevet");
            value_produit.put("description", "Description table de chevet");
            value_produit.put("prix", 50);
            value_produit.put("id_ray", rayonId);
            db.insert("produit", null, value_produit);
            Log.d("DEBUG", "produit inséré avec l'id: " );
        }

        // ------------------------
        // employe
        // ------------------------
        ContentValues value_employe = new ContentValues();
        value_employe.put("nom", "bayle");
        value_employe.put("prenom", "cyril");
        value_employe.put("id_mag", magasinId);
        value_employe.put("id_ray", rayonId);
        db.insert("employe", null, value_employe);
        Log.d("DEBUG", "employe inséré avec l'id: " );

        value_employe.put("nom", "marchand");
        value_employe.put("prenom", "julien");
        value_employe.put("id_mag", magasinId);
        value_employe.put("id_ray", rayonId);
        db.insert("employe", null, value_employe);
        Log.d("DEBUG", "employe inséré avec l'id: " );

    }
}

