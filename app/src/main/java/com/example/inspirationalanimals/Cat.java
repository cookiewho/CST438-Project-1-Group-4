package com.example.inspirationalanimals;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Cat {
//    @SerializedName("url")
//    private List<String> catString;
//
//    public List<String> getCats() {
//        List<String> cats =  new ArrayList<>();
//        for (String cat: catString){
//            cats.add(cat);
//        }
//        return cats;
//    }
@SerializedName("url")
private String catString;

    public String getCats() {
        return catString;
    }



}
