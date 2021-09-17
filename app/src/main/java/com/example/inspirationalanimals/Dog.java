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
    ArrayList<Dog> dogList;

    public ArrayList<Dog> getDogList(){
        return dogList;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "messageFromApi")
    private String messageFromApi;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "q")
    private String q;

    @ColumnInfo(name = "a")
    private String a;

    @ColumnInfo(name = "h")
    private String h;

    public Dog(String messageFromApi, String status, String q, String a, String h) {
        this.messageFromApi = messageFromApi;
        this.status = status;
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

    public String getMessageFromApi() {
        return messageFromApi;
    }

    public void setMessageFromApi(String message) {
        this.messageFromApi = message;
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
