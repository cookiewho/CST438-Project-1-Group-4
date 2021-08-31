package com.example.inspirationalanimals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    String picture_path;

    public Cat(JSONObject jsonObject) throws JSONException {
        picture_path = jsonObject.getString("url");
    }
    //this bit is going to be adding dog objects into a list that will later be used to populate the recycler view
    public static List<Cat> fromJSONArray(JSONArray catJSONArray) throws JSONException{
        List<Cat> cats = new ArrayList<>();
        for (int i =0; i < catJSONArray.length(); i++){
            cats.add(new Cat(catJSONArray.getJSONObject(i)));
        }
        return cats;
    }
}
