package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

<<<<<<< HEAD
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "cats")
public class Cat {
    @SerializedName("url")
    String picture_path;
    public String getCats() {
        return picture_path;
    }
    
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
    public static List<Cat> fromJSONArray(JSONArray catJSONArray) throws JSONException {
        List<Cat> cats = new ArrayList<>();
        for (int i =0; i < catJSONArray.length(); i++){
            cats.add(new Cat(catJSONArray.getJSONObject(i)));
        }
        return cats;
    }

    public Cat(String url, String q, String a, String h) {
        this.url = url;
        this.q = q;
        this.a = a;
        this.h = h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getH() {
        return h;
    }
=======
public class Cat {
    @SerializedName("url")
    private String catString;
>>>>>>> 183bf007f2fdc07c39b5b40cee3a6cccc54512b8

    public String getCats() {
        return catString;
    }

}
