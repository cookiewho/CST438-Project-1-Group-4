package com.example.inspirationalanimals;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "cats")
public class Cat {
    String picture_path;
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "q")
    private String q;

    @ColumnInfo(name = "a")
    private String a;

    @ColumnInfo(name = "h")
    private String h;

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
