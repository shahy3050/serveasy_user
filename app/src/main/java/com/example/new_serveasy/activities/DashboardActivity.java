package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.new_serveasy.R;

public class DashboardActivity extends AppCompatActivity {

    private CardView addVehicle, searchGarage, feedback, services, serviceathome, support;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbard);


        addVehicle = findViewById(R.id.add_vehicle_card_view);
        searchGarage = findViewById(R.id.search_card_view);
        feedback = findViewById((R.id.feedback_card_view));
        services = findViewById(R.id.services_card_view);
        support = findViewById(R.id.support_card_view);
        serviceathome = findViewById(R.id.service_at_home_card_view);

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

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, DemoActivity.class));

            }

        });
        serviceathome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, DemoActivity.class));

            }

        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, DemoActivity.class));

            }

        });


    }
}
