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
    private ListView listView;
    private ArrayList<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AkeiDatabaseHelper dbHelper = new AkeiDatabaseHelper(this);
        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        //dbHelper.deleteData(db);
        /* dbHelper.InsertData(db); */
        //DataSeeder.inserrDatas(db);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        categories = new ArrayList<>();
        categories.add("Produits");
        categories.add("Magasins");
        categories.add("Employés");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories.get(position);
                Intent intent = new Intent(MainActivity.this, Rayon.class);
                intent.putExtra("category", selectedCategory);
                startActivity(intent);
            }
        });

    }


}