package com.example.inspirationalanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private static AppDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        database = AppDB.getInstance(this);
        database.seed();

        String currentUsername = getIntent().getStringExtra("CURRENT_USERNAME");
        User currentUser = (User) database.getUserByName(currentUsername);
    }



    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }
}
