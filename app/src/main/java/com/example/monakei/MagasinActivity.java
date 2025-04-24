package com.example.monakei;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import android.widget.ListView;

public class MagasinActivity extends AppCompatActivity {
    private ListView magasinListView;
    private ArrayList<String> magasins;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_magasin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupérer la catégorie sélectionnée via l'Intent
        String selectedCategory = getIntent().getStringExtra("category");

        // Trouver le TextView et définir le texte
        TextView textView = findViewById(R.id.categoryTextView);
        textView.setText("Vous avez sélectionné : " + selectedCategory);

        // Charger les magasins depuis la base de données
        //loadMagasinsFromDatabase();
    }
    /*
    private void loadMagasinsFromDatabase() {
        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        Cursor cursor = dbHelper.getAllMagasins();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String magasinName = cursor.getString(cursor.getColumnIndexOrThrow("nom"));
                magasins.add(magasinName); // Ajouter chaque nom à la liste
            }
            cursor.close();
        }

        // Notifier l'adaptateur des nouvelles données
        adapter.notifyDataSetChanged();
    }
    */
}