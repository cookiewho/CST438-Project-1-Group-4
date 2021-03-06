package com.example.inspirationalanimals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonAPI {
    @GET("quotes")
    Call<List<Quote>>getQuotes();
    @GET("50")
    Call<Dog>getDogs();
    @GET("search?limit=50")
    Call<List<Cat>>getCats();
}
