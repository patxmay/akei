package com.example.monakei;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.database.Cursor;

public class RayonActivity extends AppCompatActivity {
    private ListView rayonListView;
    private ArrayList<String> rayons;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        ////setContentView(R.layout.activity_rayon); //  lie les éléments de l'interface utilisateur au code de l'activité.
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */
        // Récupérer la catégorie sélectionnée via l'Intent
        ////String selectedCategory = getIntent().getStringExtra("category");
        // Trouver le TextView et définir le texte
        ////TextView textView = findViewById(R.id.categoryTextView);
        ////textView.setText("Vous avez sélectionné : " + selectedCategory);

        // Initialiser la liste et l'adaptateur
        //rayons = new ArrayList<>();
        //rayonListView = findViewById(R.id.rayonListView);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rayons);
        //rayonListView.setAdapter(adapter);
        // Charger les rayons depuis la base de données
        //loadRayonsFromDatabase();

        // On récupére le magasin sélectionné via l'intent et l'utiliser
        // pour afficher les rayons associés à ce magasin.
        setContentView(R.layout.activity_rayon);

        // Récupérer le magasin sélectionné
        String selectedMagasin = getIntent().getStringExtra("selectedMagasin");

        // Utiliser le nom du magasin sélectionné pour afficher les rayons
        TextView magasinTextView = findViewById(R.id.magasinTextView);
        magasinTextView.setText("Magasin sélectionné : " + selectedMagasin);

        loadRayonsFromDatabase();
    }

    private void loadRayonsFromDatabase() {
        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        Cursor cursor = dbHelper.getAllRayons();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String rayonName = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                rayons.add(rayonName); // Ajouter chaque nom à la liste
            }
            cursor.close();
        }

        // Notifier l'adaptateur des nouvelles données
        adapter.notifyDataSetChanged();
    }
}