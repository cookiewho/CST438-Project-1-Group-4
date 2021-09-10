package com.example.inspirationalanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class SignUpActivity extends AppCompatActivity {

    private TextView errorMessage;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText passwordVerify;
    private Button btnSignUp;
    private static AppDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = AppDB.getInstance(this);
        database.seed();

        errorMessage = findViewById(R.id.errorMessage);
        username = findViewById(R.id.signUpUsername);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        passwordVerify = findViewById(R.id.signUpPasswordVerify);
        btnSignUp = findViewById((R.id.btnSignUp));


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validInfo = validateSignUpInfo(errorMessage, username.getText().toString(), email.getText().toString(), password.getText().toString(), passwordVerify.getText().toString());
                if(!validInfo){
                    Toast toast = Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Sign up successful", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    protected static boolean validateSignUpInfo(TextView errorMessage, String username, String email, String password, String passwordVerify) {

        boolean validUsername = true;
        boolean validEmail = true;
        boolean validPassword = false;

        List<User> existingUsers = database.getAllUsers();

        for (User user : existingUsers) {
            if (username.equals(user.getUsername())) {
                validUsername = false;
            }
            if (email.equals(user.getEmail())) {
                validEmail = false;
            }
        }
        if (password.equals(passwordVerify) && (password.length() != 0)) {
            validPassword = true;
        }

        if (validUsername && validEmail && validPassword) {
            database.addUser(username, password, email);
            return true;
        } else {
            //Toast.makeText(getApplicationContext(), "Unable to sign up but not legit", Toast.LENGTH_SHORT).show();
            setErrorMessage(errorMessage, validUsername, validEmail, validPassword);
            return false;
        }
    }

    private static void setErrorMessage(TextView errorMessage, boolean validUsername, boolean validEmail, boolean validPassword) {
        String errorMessageText = "ERROR: ";

        if (!validUsername){
            errorMessageText += "Username already in use. ";
        }
        if (!validEmail){
            errorMessageText += "Email already in use. ";
        }
        if (!validPassword){
            errorMessageText += "Passwords do not match. ";
        }
        errorMessage.setText(errorMessageText);
    }


    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }
}