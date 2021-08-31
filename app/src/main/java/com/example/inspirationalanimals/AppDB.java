package com.example.inspirationalanimals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
}
