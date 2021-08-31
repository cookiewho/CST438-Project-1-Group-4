package com.example.inspirationalanimals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    String picture_path;

    public Dog(JSONObject jsonObject) throws JSONException {
        picture_path = jsonObject.getString("message");
    }
    //this bit is going to be adding dog objects into a list that will later be used to populate the recycler view
    public static List<Dog> fromJSONArray(JSONArray dogJSONArray) throws JSONException{
        List<Dog> dogs = new ArrayList<>();
        for (int i =0; i < dogJSONArray.length(); i++){
            dogs.add(new Dog(dogJSONArray.getJSONObject(i)));
        }
        return dogs;
    }
}
