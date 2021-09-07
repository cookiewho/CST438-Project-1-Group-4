package com.example.inspirationalanimals;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.inspirationalanimals", appContext.getPackageName());
    }

    @Test
    public void DBCreatedTest() {
        // Checking that DB is created
    }

    @Test
    public void userCreationTest() {
        // Mocking user being created
    }

    @Test
    public void getUserTest() {
        // checking if getUser works
    }

    @Test
    public void updateUserTest() {
        // Checking if users are able to be updated
    }
}