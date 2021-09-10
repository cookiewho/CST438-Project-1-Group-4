package com.example.inspirationalanimals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SignUpValidationTest {
    @Test
    public void usernameFormatsInvalid() {
        // Check empty string fails
        assertEquals("Username is empty. ", SignUpActivity.verifyUsername(""));

        // Check long username fails
        assertEquals("Username is too long. ", SignUpActivity.verifyUsername("supercalifragilisticexpialidocious"));

        //check that taken username fails
        //assertEquals("Email is not valid. ", SignUpActivity.verifyUsername("admin@email.com"));
    }

    @Test
    public void usernameFormatsValid() {
        // Check that email works
        assertEquals("", SignUpActivity.verifyUsername("superOGusername"));
    }

    @Test
    public void emailFormatsInvalid() {
        // Check empty string fails
        assertEquals("Email is empty. ", SignUpActivity.verifyEmail(""));

        // Check non special string fails
        assertEquals("Email is not valid. ", SignUpActivity.verifyEmail("validemail"));

        //check if added @ symbol still fails
        assertEquals("Email is not valid. ", SignUpActivity.verifyEmail("validemail@"));

        //check if added . still fails
        assertEquals("Email is not valid. ", SignUpActivity.verifyEmail("validemail@."));

        //check that non-alphabetical characters in between site name fail
        assertEquals("Email is not valid. ", SignUpActivity.verifyEmail("validemail@?>23.4)_56"));

        //check that taken username fails
        //assertEquals("Email is not valid. ", SignUpActivity.verifyEmail("admin@email.com"));
    }

    @Test
    public void emailFormatsValid() {
        // Check that email works
        assertEquals("", SignUpActivity.verifyEmail("validemail@csumb.edu"));
    }

    @Test
    public void passwordFormatsInvalid() {
        // Check empty string fails
        assertEquals("Password is empty. ", SignUpActivity.verifyPassword("", ""));

        // Check short username fails
        assertEquals("Password is too short. ", SignUpActivity.verifyPassword("buh", "buh"));

        //check that different passwords fail
        assertEquals("Passwords do not match. ", SignUpActivity.verifyPassword("validPassword", "invalidPassword"));
        }

    @Test
    public void passwordFormatsValid() {
        // Check that passwords match and are valid
        assertEquals("", SignUpActivity.verifyPassword("validPassword", "validPassword"));
    }
}