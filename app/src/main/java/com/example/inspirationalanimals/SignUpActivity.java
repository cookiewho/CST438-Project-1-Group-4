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

    protected static boolean validateSignUpInfo(String username, String email, String password, String passwordVerify) {
        return false;
    }
}