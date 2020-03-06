package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private EditText pNameET, pContactET, pEmailET, pAddressET;
    private Button saveProfileButton;
    DatabaseReference dbUser;

    private void bindViews() {

        pNameET = findViewById(R.id.p_name_et);
        pContactET = findViewById(R.id.p_contact_et);
        pEmailET = findViewById(R.id.p_email_et);
        pAddressET = findViewById(R.id.p_address_et);
        saveProfileButton = findViewById(R.id.p_save_bt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindViews();
        dbUser = FirebaseDatabase.getInstance().getReference("Users");


        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Toast.makeText(getApplicationContext(), "Added User Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this, DashboardActivity.class));


            }
        });

    }

    private void addUser() {

        final String uName, uContact, uEmail, uAddress;
        String id = dbUser.push().getKey();


        uName = pNameET.getText().toString();
        uContact = pContactET.getText().toString();
        uEmail = pEmailET.getText().toString();
        uAddress = pAddressET.getText().toString();

        User user = new User(id, uName, uEmail, uContact, uAddress);
        dbUser.child(id).setValue(user);


    }
}
