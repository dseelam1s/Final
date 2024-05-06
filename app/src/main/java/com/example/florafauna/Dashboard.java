package com.example.florafauna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Activity {
    private Button searchSpeciesButton, savedSpeciesButton, educationalContentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        searchSpeciesButton = findViewById(R.id.searchSpeciesButton);
        savedSpeciesButton = findViewById(R.id.savedSpeciesButton);
        educationalContentButton = findViewById(R.id.educationalContentButton);

        searchSpeciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to search species activity
                startActivity(new Intent(Dashboard.this, IdentifySpecies.class));
            }
        });

        savedSpeciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to saved species activity
                startActivity(new Intent(Dashboard.this, SearchSpeciesActivity.class));
            }
        });

        educationalContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to educational content activity
                startActivity(new Intent(Dashboard.this, EducationalContentActivity.class));
            }
        });
    }
}


