package com.example.monakei;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView magasinListView;
    private ArrayList<String> magasins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.deleteData(db);
        /* dbHelper.InsertData(db); */
        DataSeeder.inserrDatas(db);

        super.onCreate(savedInstanceState);
        // Charger le layout activity_magasin.xml
        setContentView(R.layout.activity_magasin);
        // Initialiser le ListView
        magasinListView = findViewById(R.id.magasinListView);
        // Charger les magasins depuis la base de données
        magasins = dbHelper.getAllMagasins();
        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, magasins);
        magasinListView.setAdapter(adapter);
        // Ajouter un écouteur pour détecter les clics sur les magasins
        magasinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMagasin = magasins.get(position);
                // Lancer RayonActivity avec le magasin sélectionné
                Intent intent = new Intent(MainActivity.this, RayonActivity.class);
                intent.putExtra("selectedMagasin", selectedMagasin);
                startActivity(intent);
            }
        });
    }
}