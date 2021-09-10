package com.example.inspirationalanimals;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dogs")
public class Dog {

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
