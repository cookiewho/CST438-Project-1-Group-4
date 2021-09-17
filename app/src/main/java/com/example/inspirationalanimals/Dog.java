package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

public class Dog {
    @SerializedName("message")
    private String dogString;

    public String getDogs() {
        return dogString;
    }
}
