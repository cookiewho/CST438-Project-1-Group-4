package com.example.inspirationalanimals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {User.class, Cat.class}, version = 2, exportSchema = false)
public abstract class AppDB extends RoomDatabase {


    private static AppDB sInstance;
    public abstract UserDAO user();
    public abstract CatDao cat();

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

        if (cat().count() == 0) {
            runInTransaction(() -> {
                Cat dummyCat = new Cat("https://cdn2.thecatapi.com/images/bj2.jpg", "Be royal in your own fashion: act like a king to be treated like one.", "Robert Greene", "<blockquote>&ldquo;Be royal in your own fashion: act like a king to be treated like one.&rdquo; &mdash; <footer>Robert Greene</footer></blockquote>");

                cat().insertCats(dummyCat);
            });
        }
    }

    public List<User> getAllUsers(){
        return user().getAllUsers();
    }

    public List<User> getUserByName(String name){
        return user().getUserByUsername(name);
    }
}
