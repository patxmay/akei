package com.example.monakei;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProduitActivity extends AppCompatActivity {
    private ListView produitListView;
    private ArrayList<Produit> produits;
    private AkeiDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // On récupére le rayon sélectionné via l'intent et on l'utilise
        // pour afficher les produits associés à ce rayon.
        setContentView(R.layout.activity_produit);

        // Récupérer l'ID du magasin sélectionné à partir de l'intent
        int selectedRayonId = getIntent().getIntExtra("selectedRayonId", -1);
        String selectedProduitName = getIntent().getStringExtra("selectedProduitName");

        // Initialiser la base de données
        dbHelper = new AkeiDatabaseHelper(this);
        // Initialiser la liste et l'adaptateur
        produitListView = findViewById(R.id.produitListView);
        // Charger les rayons depuis la base de données pour le magasin sélectionné
        loadProduitsFromDatabase(selectedRayonId);

        // Ajouter un écouteur pour détecter les clics sur les magasins
        produitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupérer le rayon sélectionné
                Produit selectedProduit = produits.get(position);

                // Passer l'ID du rayon à produitActivity
                Intent intent = new Intent(ProduitActivity.this, ProduitActivity.class);
                intent.putExtra("selectedRayonId", selectedProduit.getId());
                intent.putExtra("selectedRayonnName", selectedProduit.getNom());
                startActivity(intent);
            }
        });
    }
    private void loadProduitsFromDatabase(int rayonId) {
        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        Cursor cursor = dbHelper.getProduitsForRayon(rayonId);
        // Vérifier si un ID valide a été passé
        if (rayonId == -1) {
            // Pas d'ID valide, ne pas charger les données
            return;
        }
        ArrayList produits = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String produitName = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                produits.add(produitName);
            }
            cursor.close();
        }
        ArrayAdapter<Magasin> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produits);
        produitListView.setAdapter(adapter);

    }
}