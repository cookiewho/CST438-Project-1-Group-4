package com.example.inspirationalanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
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
    List<Quote> quotes;
    List<Dog> dogs;
    List<Cat> cats;

    private static AppDB database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        database = AppDB.getInstance(this);
        database.seed();

        String currentUsername = getIntent().getStringExtra("CURRENT_USERNAME");
        User currentUser = (User) database.getUserByName(currentUsername);

        RecyclerView rv = findViewById(R.id.rvAnimal);
        quotes = new ArrayList<>();
        cats = new ArrayList<>();
        dogs = new ArrayList<>();

        InspirationAdapter inspirationAdapter = new InspirationAdapter(this, quotes);

        rv.setAdapter(inspirationAdapter);

        //call the APIs
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://zenquotes.io/api/quotes").addConverterFactory(GsonConverterFactory.create()).build();
        jsonAPI jsonAPI = (com.example.inspirationalanimals.jsonAPI) retrofit.create(Quote.class);
        Call<List<Quote>> call = jsonAPI.getQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()){
                    Log.d("Response","Response is outside of the 200-300 range!");
                    return;
                }
                List<Quote> quotes =  response.body();
                for( Quote quote: quotes){
                    Log.d("hi", quote.getQuote());

                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {

            }
        });
    }
    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

}
