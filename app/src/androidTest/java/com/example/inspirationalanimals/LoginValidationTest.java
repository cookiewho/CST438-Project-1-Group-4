package com.example.inspirationalanimals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class LoginValidationTest {
    private Context appContext;
    private static AppDB database;

    @Before
    public void init() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void validateLogin() {
        database = AppDB.getInstance(appContext);

        // incorrect username
        List<User> user = database.getUserByName("ad");
        assertEquals(0, user.size());
    }
}
