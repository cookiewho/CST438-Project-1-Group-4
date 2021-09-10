package com.example.inspirationalanimals;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDao {

    @Insert
    void addDog(Dog dog);

    @Query("SELECT COUNT(*) FROM dogs")
    int count();

    @Query("SELECT * FROM dogs")
    List<Dog> getAllDogs();

    @Insert
    long[] insertDogs(Dog... dogs);
}
