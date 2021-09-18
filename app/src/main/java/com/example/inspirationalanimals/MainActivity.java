package com.example.inspirationalanimals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login_button;
    private TextView text;
    private TextView signUpLink;
    private static AppDB database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDB.getInstance(this);
        database.seed();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login);
        signUpLink = findViewById(R.id.signUpLink);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if(name.isEmpty() && pass.isEmpty()){
                    username.setError("This field cannot be blank");
                    password.setError("This field cannot be blank");
                }

                if (name.isEmpty()) {
                    username.setError("This field cannot be blank");
                }

                if (pass.isEmpty()) {
                    password.setError("This field cannot be blank");
                }

                boolean isValid = validate(name, pass);
                if(isValid){
                    loadHomeActivity(view, username.getText().toString());
                }else{
                    alertDialog();
                    boolean foundUser = findUser(name);
                    if(!foundUser){
                        username.setError("Your username is incorrect");
                    } else {
                        password.setError("Your password is incorrect");
                    }
                }
            }
        });

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSignupActivity(view);
            }
        });
    }

    static boolean validate(String name, String pass) {
        List<User> all_users = database.getAllUsers();

        for(User u:all_users){
            if ((u.getUsername()).equals(name) && (u.getPassword()).equals(pass)){
                return true;
            }
        }

        return false;
    }

    static boolean findUser(String name){
        List<User> all_users = database.getAllUsers();

        for(User u:all_users){
            if(u.getUsername().equals(name)){
                return true;
            }
        }

        return false;
    }

    private void alertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Your username and/or password is incorrect.");
        dialog.setTitle("Invalid Credentials");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    private void loadSignupActivity(View view) {
        Intent intent = SignUpActivity.getIntent(getApplicationContext());
        startActivity(intent);
    }

    private void loadHomeActivity(View view, String username) {
        Intent intent = HomeActivity.getIntent(getApplicationContext());
        intent.putExtra("CURRENT_USERNAME", username);
        startActivity(intent);
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}