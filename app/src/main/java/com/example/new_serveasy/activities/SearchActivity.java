package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.Garage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    public ArrayList<Garage> garage;
    private Spinner areaSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        areaSpinner = findViewById(R.id.search_spinner);
        Button searchButton = findViewById(R.id.search_garage_button);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchGarage();
            }
        });
    }

    private void searchGarage() {
//        String area, name, city, contact;


        final String searchArea = areaSpinner.getSelectedItem().toString();
        Log.d("Spinner Value", searchArea);
        final DatabaseReference dbGarage = FirebaseDatabase.getInstance().getReference();

        Query q = dbGarage.child("Garages").orderByChild("gArea").equalTo(searchArea);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                garage = new ArrayList<>();
                Log.d("DataSnapshot", dataSnapshot + "");


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    garage.add(postSnapshot.getValue(Garage.class));
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgName() + "");
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgCity() + "");
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgContact() + "");
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgArea() + "");
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgFullAddress() + "");
                    Log.d("Inside Loop", postSnapshot.getValue(Garage.class).getgOwner() + "");


                }


                Log.d("gg", garage + "");

                Bundle b = new Bundle();
                b.putParcelableArrayList("garageList", garage);
                Intent i = new Intent(SearchActivity.this, GarageRecyclerActivity.class);
                i.putExtras(b);
                startActivity(i);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
