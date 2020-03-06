package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.new_serveasy.R;

public class DashboardActivity extends AppCompatActivity {

    private CardView addVehicle, searchGarage, feedback, profile, serviceathome, support;
    private ImageView shutdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbard);


        addVehicle = findViewById(R.id.add_vehicle_card_view);
        searchGarage = findViewById(R.id.search_card_view);
        feedback = findViewById((R.id.feedback_card_view));
        profile = findViewById(R.id.profile_card_view);
        support = findViewById(R.id.support_card_view);
        serviceathome = findViewById(R.id.service_at_home_card_view);
        shutdown = findViewById(R.id.shutdown_iv);

        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardActivity.this, VehicleDetails.class));

            }
        });


        searchGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SearchActivity.class));
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, FeedbackActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));

            }

        });
        serviceathome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));

            }

        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));

            }

        });

        shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SignInActivity.class));
                finish();
            }
        });


    }
}
