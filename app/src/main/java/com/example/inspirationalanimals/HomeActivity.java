package com.example.inspirationalanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inspirationalanimals.adapters.InspirationAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private static AppDB database;
    List<Quote> quotes;
    List<Dog> dogs;
    List<Cat> cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        database = AppDB.getInstance(this);
        database.seed();

        String currentUsername = getIntent().getStringExtra("CURRENT_USERNAME");
        User currentUser = database.getUserByName(currentUsername).get(0);
        Toast.makeText(getApplicationContext(), "Hello "+ currentUsername + "!", Toast.LENGTH_SHORT).show();


        RecyclerView rv = findViewById(R.id.rvAnimal);
        quotes = new ArrayList<>();
        cats = new ArrayList<>();
        dogs = new ArrayList<>();

        final InspirationAdapter inspirationAdapter = new InspirationAdapter(this, quotes);
        //set adapter for the recycler view
        rv.setAdapter(inspirationAdapter);
        //sets layout manager for the recycler view
        rv.setLayoutManager(new LinearLayoutManager(this));

        //call the APIs
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://zenquotes.io/api/quotes/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonAPI jsonAPI = retrofit.create(jsonAPI.class);
        Call<List<Quote>> call = jsonAPI.getQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if (!response.isSuccessful()) {
                    Log.d("Response", "Response is outside of the 200-300 range!");
                    return;
                }
                for (Quote quote : response.body()) {
                    Log.d("HOME", quote.getQuotes());
                    quotes.add(quote);
                    inspirationAdapter.notifyDataSetChanged();
                }
                Log.d("HOME", String.valueOf(quotes.size()));
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }
}
