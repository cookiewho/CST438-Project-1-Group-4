package com.example.inspirationalanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login_button;
    private static ArrayList<String> credentials = loadCredentials();

    private static ArrayList<String> loadCredentials() {
        ArrayList<String> admin = new ArrayList<String>();
        admin.add("Admin");
        admin.add("Pass");
        admin.add("1");
        return admin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                boolean isValid = validate(name, pass);
            }
        });
    }

    static boolean validate(String name, String pass) {
        boolean match_user = false;
        boolean match_pass = false;
        
        if(name.equals(credentials.get(0)) && pass.equals(credentials.get(1))){
            match_user = true;
            match_pass = true;
        }

        return match_user && match_pass;
    }
}