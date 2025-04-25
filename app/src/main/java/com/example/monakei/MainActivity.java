package com.example.monakei;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.deleteData(db);
        /* dbHelper.InsertData(db); */
        DataSeeder.inserrDatas(db);

        super.onCreate(savedInstanceState);

        // Démarrer MagasinActivity dès le lancement de l'application
        Intent intent = new Intent(this, MagasinActivity.class);
        startActivity(intent);

        // Terminer MainActivity pour qu'elle ne reste pas dans la pile
        finish();


    }
}