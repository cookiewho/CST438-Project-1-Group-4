package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("url")
    private String catString;

    public String getCats() {
        return catString;
    }

}
