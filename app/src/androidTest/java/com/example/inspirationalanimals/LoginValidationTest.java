package com.example.inspirationalanimals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class LoginValidationTest {
    private Context appContext;
    private static AppDB database;

    @Before
    public void init() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        System.out.println("hello");
    }

    @Test
    public void incorrectUsername() {
        database = AppDB.getInstance(appContext);
        List<User> user_list;

        // incorrect username
        user_list = database.getUserByName("ad");
        assertEquals(0, user_list.size());
    }

    @Test
    public void correctUsername(){
        database = AppDB.getInstance(appContext);
        List<User> user_list;

        // correct username
        user_list = database.getUserByName("admin");
        assertEquals(1, user_list.size());
    }

    @Test
    public void correctUsernameIncorrectPassword(){
        database = AppDB.getInstance(appContext);
        List<User> user_list;
        User user;
        String incorrect_pass = "password";

        // correct username, incorrect password
        user_list = database.getUserByName("admin");
        user = user_list.get(0);
        assertNotEquals(user.getPassword(), incorrect_pass);
    }

    @Test
    public void correctUsernameCorrectPassword(){
        database = AppDB.getInstance(appContext);
        List<User> user_list;
        User user;
        String correct_pass = "admin";

        // correct username, correct password
        user_list = database.getUserByName("admin");
        user = user_list.get(0);
        assertEquals(user.getPassword(), correct_pass);
    }


}
