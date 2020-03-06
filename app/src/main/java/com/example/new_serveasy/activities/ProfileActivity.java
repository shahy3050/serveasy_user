package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private EditText pNameET, pContactET, pAddressET;
    private Button saveProfileButton;
    private RadioButton maleButton, femaleButton;
    private TextInputLayout pNameInput, pContactInput, pAddressInput;
    DatabaseReference dbUser;

    private void bindViews() {

        pNameET = findViewById(R.id.p_name_et);
        pContactET = findViewById(R.id.p_contact_et);
        pAddressET = findViewById(R.id.p_address_et);
        saveProfileButton = findViewById(R.id.p_save_bt);
        maleButton = findViewById(R.id.male_radio);
        femaleButton = findViewById(R.id.female_radio);
        pNameInput = findViewById(R.id.p_name_input);
        pAddressInput = findViewById(R.id.p_address_input);
        pContactInput = findViewById(R.id.p_contact_input);

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


            }
        });

    }

    private void addUser() {
        boolean isValid = true;
        int count = 10;
        final String uName, uContact, uAddress;
        String uGender = null;
        String id = dbUser.push().getKey();


        uName = pNameET.getText().toString();
        uContact = pContactET.getText().toString();
        uAddress = pAddressET.getText().toString();

        if (maleButton.isChecked()) {
            uGender = maleButton.getText().toString();
        }

        if (femaleButton.isChecked()) {
            uGender = femaleButton.getText().toString();
        }


        //--Validating User Name--
        if (uName.isEmpty()) {
            pNameInput.setError("Name is Empty");
            isValid = false;
            pNameET.requestFocus();
        } else {
            pNameInput.setErrorEnabled(false);
        }


        //--Validating User Contact--
        if (uContact.isEmpty()) {
            pContactInput.setError("Contact is Empty");
            isValid = false;
            pContactET.requestFocus();
        } else if (uContact.length() != count) {
            pContactInput.setError("Contact Number Should be 10 digits");
            isValid = false;
            pContactET.requestFocus();
        } else {
            pContactInput.setErrorEnabled(false);
        }

        //--Validating User Gender--
        if (!maleButton.isChecked() && !femaleButton.isChecked()) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
        }


        //--Validating User Address--
        if (uAddress.isEmpty()) {
            pAddressInput.setError("Address is Empty");
            isValid = false;
            pAddressET.requestFocus();
        } else {
            pAddressInput.setErrorEnabled(false);
        }

        if (isValid) {


            User user = new User(id, uName, uGender, uContact, uAddress);
            dbUser.child(id).setValue(user);
            Toast.makeText(getApplicationContext(), "Added User Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileActivity.this, DashboardActivity.class));
        }  //            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();


    }
}
