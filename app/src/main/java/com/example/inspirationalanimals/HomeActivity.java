package com.example.inspirationalanimals;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inspirationalanimals.adapters.InspirationAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Quote> quotes;
    List<Dog> dogs;
    List<Cat> cats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView rv = findViewById(R.id.rvAnimal);
        quotes = new ArrayList<>();
        cats = new ArrayList<>();
        dogs = new ArrayList<>();

        InspirationAdapter inspirationAdapter = new InspirationAdapter(this, quotes);

        rv.setAdapter(inspirationAdapter);

        //call the APIs
    }
}
