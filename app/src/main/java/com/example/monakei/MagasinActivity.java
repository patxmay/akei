package com.example.monakei;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MagasinActivity extends AppCompatActivity {
    private ListView magasinListView;
    private AkeiDatabaseHelper dbHelper;
    private ArrayList<Magasin> magasins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Charger le layout pour afficher les magasins
        setContentView(R.layout.activity_magasin);
        // Initialiser la base de données
        dbHelper = new AkeiDatabaseHelper(this);
        // Référencer le ListView
        magasinListView = findViewById(R.id.magasinListView);
        // Charger les magasins depuis la base de données et configurer le ListView
        loadMagasinsFromDatabase();

        // Ajouter un écouteur pour détecter les clics sur les magasins
        magasinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupérer le magasin sélectionné
                magasins = dbHelper.getAllMagasins();
                Magasin selectedMagasin = magasins.get(position);

                // Passer l'ID du magasin à RayonActivity
                Intent intent = new Intent(MagasinActivity.this, RayonActivity.class);
                intent.putExtra("selectedMagasinId", selectedMagasin.getId());
                intent.putExtra("selectedMagasinName", selectedMagasin.getNom());
                startActivity(intent);
            }
        });
    }

    private void loadMagasinsFromDatabase() {
        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        Cursor cursor = dbHelper.getMagasins();

        ArrayList magasins = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id_mag"));
                String nom = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                magasins.add(new Magasin(id, nom));
            }
            cursor.close();
        }
        // Configurer l'adaptateur
        ArrayAdapter<Magasin> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, magasins);

        // Lier l'adaptateur au ListView
        magasinListView.setAdapter(adapter);
    }

}