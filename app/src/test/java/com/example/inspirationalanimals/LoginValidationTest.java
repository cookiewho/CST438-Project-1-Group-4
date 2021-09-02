package com.example.inspirationalanimals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginValidationTest {
    @Test
    public void correctCredentials() {
        assertEquals(true, MainActivity.validate("admin", "admin"));
    }

    @Test
    public void incorrectCredentials() {
        assertEquals(false, MainActivity.validate("Adm1n", "Passwrd"));
    }

    @Test
    public void incorrectUsername() {
        assertEquals(false, MainActivity.validate("Adm1n", "Password"));
    }

    @Test
    public void incorrectPassword() {
        assertEquals(false, MainActivity.validate("Admin", "Passwrd"));
    }
}