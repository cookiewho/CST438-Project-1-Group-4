package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    @SerializedName("message")
    private List<String> dogString;

    public List<String> getDogs() {
        List<String> dogs = new ArrayList<>();
        for (String dog: dogString){
            dogs.add(dog);
        }
        return dogs;
    }
}
