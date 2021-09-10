package com.example.inspirationalanimals;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CatDao {

    @Insert
    void addCat(Cat cat);

    @Query("SELECT COUNT(*) FROM cats")
    int count();

    @Query("SELECT * FROM cats")
    List<User> getAllCats();

    @Insert
    long[] insertCats(Cat... cats);
}
