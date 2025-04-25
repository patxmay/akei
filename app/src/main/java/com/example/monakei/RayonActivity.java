package com.example.monakei;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.database.Cursor;

public class RayonActivity extends AppCompatActivity {
    private ListView rayonListView;
    private ArrayList<Rayon> rayons;
    private AkeiDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // On récupére le magasin sélectionné via l'intent et l'utiliser
        // pour afficher les rayons associés à ce magasin.
        setContentView(R.layout.activity_rayon);

        // Récupérer l'ID du magasin sélectionné à partir de l'intent
        int selectedMagasinId = getIntent().getIntExtra("selectedMagasinId", -1);
        String selectedMagasinName = getIntent().getStringExtra("selectedMagasinName");

        // Initialiser la base de données
        dbHelper = new AkeiDatabaseHelper(this);
        // Initialiser la liste et l'adaptateur
        rayonListView = findViewById(R.id.rayonListView);
        // Charger les rayons depuis la base de données pour le magasin sélectionné
        loadRayonsFromDatabase(selectedMagasinId);

        // Ajouter un écouteur pour détecter les clics sur les rayons
        rayonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupérer le rayon sélectionné
                rayons = dbHelper.getAllRayonsForMagasin(selectedMagasinId);
                Rayon selectedRayon = rayons.get(position);
                // Passer l'ID du rayon à produitActivity
                Intent intent = new Intent(RayonActivity.this, ProduitActivity.class);
                intent.putExtra("selectedRayonId", selectedRayon.getId());
                intent.putExtra("selectedRayonnName", selectedRayon.getNom());
                startActivity(intent);
            }
        });
    }

    private void loadRayonsFromDatabase(int magasinId) {
        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        Cursor cursor = dbHelper.getRayonsForMagasin(magasinId);
        // Vérifier si un ID valide a été passé
        if (magasinId == -1) {
            // Pas d'ID valide, ne pas charger les données
            return;
        }
        ArrayList rayons = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String rayonName = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                rayons.add(rayonName); // Ajouter chaque nom à la liste
            }
            cursor.close();
        }
        ArrayAdapter<Magasin> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rayons);
        rayonListView.setAdapter(adapter);

    }
}