package com.example.inspirationalanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends AppCompatActivity {

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

        username = findViewById(R.id.signUpUsername);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        passwordVerify = findViewById(R.id.signUpPasswordVerify);
        btnSignUp = findViewById((R.id.btnSignUp));

    }

    protected static String validateSignUpInfo(String username, String email, String password, String passwordVerify) {

        boolean validUsername = true;
        boolean validEmail = true;
        boolean validPassword = false;

        for( User user: database.getAllUsers()){
            if(username.equals(user.getUsername())){
                validUsername = false;
            }
            if(email.equals(user.getEmail())){
                validEmail = false;
            }
        }
        if(password.equals(passwordVerify)){
            validPassword = true;
        }

        if(validUsername && validEmail && validPassword){
            database.addUser(username, password, email);
            return "";
        }
        else {
            String errorMessage = "ERROR: ";

            if (!validUsername){
                errorMessage += "Username already in use. ";
            }
            if (!validEmail){
                errorMessage += "Email already in use. ";
            }
            if (!validPassword){
                errorMessage += "Passwords do not match. ";
            }
            return errorMessage;
        }
    }
}