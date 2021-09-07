package com.example.inspirationalanimals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {


    private static AppDB sInstance;
    public abstract UserDao user();

    public static synchronized AppDB getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB.class,
                    "app.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void seed() {
        if (user().count() == 0) {
            runInTransaction(() -> {
                User admin = new User("admin", "admin", "admin@test.com");

                user().insertUsers(admin);
            });
        }
    }

    public List<User> getAllUsers(){
        return user().getAllUsers();
    }

    public List<User> getUserByName(String name){
        return user().getUserByUsername(name);
    }

    public void addUser(String username, String password, String email){
        User newUser = new User(username, password, email);
        user().addUser(newUser);
    }
}
