package com.example.new_serveasy.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_serveasy.R;
import com.example.new_serveasy.adapters.GarageAdapter;
import com.example.new_serveasy.models.Garage;

import java.util.ArrayList;

public class GarageRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GarageAdapter garageAdapter;
    private ArrayList<Garage> garageArrayList;
    Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_recyler);
        b = getIntent().getExtras();


        recyclerView = findViewById(R.id.garage_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        garageArrayList = b.getParcelableArrayList("garageList");
        Log.d("GL", garageArrayList + "");
        garageAdapter = new GarageAdapter(garageArrayList);
        recyclerView.setAdapter(garageAdapter);


    }
}
