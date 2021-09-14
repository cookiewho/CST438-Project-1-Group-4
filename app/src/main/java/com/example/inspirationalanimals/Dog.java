package com.example.inspirationalanimals;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "dogs")
public class Dog {
    @SerializedName("message")
    String picture_path;
    public String getPicture_path(){
        return picture_path;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "message")
    private String message;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "q")
    private String q;

    @ColumnInfo(name = "a")
    private String a;

    @ColumnInfo(name = "h")
    private String h;

    public Dog(String message, String status, String q, String a, String h) {
        this.message = message;
        this.status = status;
        this.q = q;
        this.a = a;
        this.h = h;
    }
    public Dog(String url){
        this.picture_path = url;
    }


    public Dog(JSONObject jsonObject) throws JSONException {
        picture_path = jsonObject.getString("message");
    }
    //this bit is going to be adding dog objects into a list that will later be used to populate the recycler view
    public static List<Dog> fromJSONArray(JSONArray dogJSONArray) throws JSONException {
        List<Dog> dogs = new ArrayList<>();
        for (int i =0; i < dogJSONArray.length(); i++){
            dogs.add(new Dog(dogJSONArray.getJSONObject(i)));
        }
        return dogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setH(String h) {
        this.h = h;
    }
}
