package com.example.monakei;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class RayonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rayons);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */
        // Récupérer la catégorie sélectionnée via l'Intent
        String selectedCategory = getIntent().getStringExtra("category");

        // Trouver le TextView et définir le texte
        TextView textView = findViewById(R.id.categoryTextView);
        textView.setText("Vous avez sélectionné : " + selectedCategory);
    }
}