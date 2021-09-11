package com.example.inspirationalanimals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonAPI {
    @GET("")
    Call<List<Quote>>getQuotes();

}
