package com.example.inspirationalanimals;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void addUser(User user);

    @Query("SELECT COUNT(*) FROM users")
    int count();

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE username = :username")
    List<User> getUserByUsername(String username);

    @Query("UPDATE users SET password = :password WHERE username = :username")
    void update(String password, String username);

    @Insert
    long[] insertUsers(User... users);
}
