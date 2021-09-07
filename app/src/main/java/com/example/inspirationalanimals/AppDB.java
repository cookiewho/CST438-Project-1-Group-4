package com.example.inspirationalanimals;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Dog.class, Cat.class}, version = 2, exportSchema = false)
public abstract class AppDB extends RoomDatabase {


    private static AppDB sInstance;
    public abstract UserDao user();
    public abstract DogDao dog();
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

        if (dog().count() == 0) {
            runInTransaction(() -> {
               Dog dummyDog = new Dog("https://images.dog.ceo/breeds/bullterrier-staffordshire/n02093256_1505.jpg", "success",  "A man with outward courage dares to die: a man with inner courage dares to live.", "Lao Tzu", "<blockquote>&ldquo;A man with outward courage dares to die: a man with inner courage dares to live.&rdquo; &mdash; <footer>Lao Tzu</footer></blockquote>");

               dog().insertDogs(dummyDog);
            });
        }

        if (cat().count() == 0) {
            runInTransaction(() -> {
                Cat dummyCat = new Cat("https://cdn2.thecatapi.com/images/bj2.jpg", "Be royal in your own fashion: act like a king to be treated like one.", "Robert Greene", "<blockquote>&ldquo;Be royal in your own fashion: act like a king to be treated like one.&rdquo; &mdash; <footer>Robert Greene</footer></blockquote>");

                cat().insertCats(dummyCat);
            });
        }
    }
}
