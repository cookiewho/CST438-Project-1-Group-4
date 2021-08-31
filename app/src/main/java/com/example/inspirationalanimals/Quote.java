package com.example.inspirationalanimals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    String quoteString;

    public Quote(JSONObject jsonObject) throws JSONException {
        quoteString = jsonObject.getString("message");
    }
    //this bit is going to be adding dog objects into a list that will later be used to populate the recycler view
    public static List<Quote> fromJSONArray(JSONArray quoteJSONArray) throws JSONException{
        List<Quote> quotes = new ArrayList<>();
        for (int i =0; i < quoteJSONArray.length(); i++){
            quotes.add(new Quote(quoteJSONArray.getJSONObject(i)));
        }
        return quotes;
    }
}
