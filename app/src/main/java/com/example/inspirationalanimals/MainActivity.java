package com.example.inspirationalanimals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                boolean isValid = validate(name, pass);
                if(isValid){
                    setContentView(R.layout.activity_list);
                    text = findViewById(R.id.textView);
                    List<User> user_data = database.getUserByName(name);
                    User user = user_data.get(0);

                    text.append("\nWelcome " + user.getUsername() + "\n");
                }else{
                    alertDialog();
                }
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
}