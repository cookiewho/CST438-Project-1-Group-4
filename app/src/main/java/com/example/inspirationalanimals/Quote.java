package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    @SerializedName("q")
    private String quoteString;

    public String getQuote() {
        return quoteString;
    }
}
