package com.example.new_serveasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.new_serveasy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    //Constants
    public static final String CHAT_PREFS = "ChatPrefs";
    public static final String DISPLAY_NAME_KEY = "username";

    //Member Variables
    private EditText UserNameET;
    private EditText EmailET;
    private EditText PasswordET;
    private EditText ConfirmPassET;
    private Button SignupButton;
    private TextView SigninTV;

    // Firebase instance variables
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Binding Views
        UserNameET = findViewById(R.id.uname_editext_signup);
        EmailET = findViewById(R.id.email_edit_text_signup);
        PasswordET = findViewById(R.id.password_edittext_signup);
        ConfirmPassET = findViewById(R.id.conf_pass_edit_text);
        SigninTV = findViewById(R.id.label_signin);

        SigninTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // Keyboard sign in action
        ConfirmPassET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.integer.register_form_finished || id == EditorInfo.IME_NULL) {
                    attemptRegistration();
                    return true;
                }
                return false;
            }
        });

        // TODO: Get hold of an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
    }


    //executed when signup button is pressed
    public void signUp(View v) {
        attemptRegistration();
    }


    private void attemptRegistration() {
        EmailET.setError(null);
        PasswordET.setError(null);

        String email = EmailET.getText().toString();
        String password = PasswordET.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            PasswordET.setError(getString(R.string.error_invalid_password));
            focusView = PasswordET;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            EmailET.setError(getString(R.string.error_field_required));
            focusView = EmailET;
            cancel = true;
        } else if (!isEmailValid(email)) {
            EmailET.setError(getString(R.string.error_invalid_email));
            focusView = EmailET;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // TODO: Call create FirebaseUser() here
            createFirebaseUser();
        }
    }

    private boolean isEmailValid(String email) {
        // You can add more checking logic here.
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Add own logic to check for a valid password (minimum 6 characters)
        String confirmPassword = ConfirmPassET.getText().toString();
        return confirmPassword.equals(password) && confirmPassword.length() > 4;

    }

    // TODO: Create a Firebase user
    private void createFirebaseUser() {

        final String email = EmailET.getText().toString();
        final String password = PasswordET.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("Serveasy", "Create User OnComplete:" + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Log.d("Serveasy", "User Not Created");
                    showErrorDialog("User Registration Failed");

                } else {
                    Log.d("Serveasy", "Email:" + email + " Password: " + password);


                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
//                    saveDisplayName();
                    Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                    finish();
                    startActivity(intent);
                }
            }
        });


    }


    /*// TODO: Save the display name to Shared Preferences
    private void saveDisplayName() {
        String displayname = UserNameET.getText().toString();
        SharedPreferences prefs = getSharedPreferences(CHAT_PREFS, 0);
        prefs.edit().putString(DISPLAY_NAME_KEY, displayname).apply();
    }*/


    // TODO: Create an alert dialog to show in case registration failed
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("OOPS")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }


}


