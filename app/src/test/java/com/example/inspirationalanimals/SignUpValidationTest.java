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
    public void correctCredentials() {
        assertEquals(true, SignUpActivity.validateSignUpInfo("Admin", "legitEmail@csumb.edu", "password", "password"));
    }

    @Test
    public void usernameTaken() {
        assertEquals(false, SignUpActivity.validateSignUpInfo("c0w0kie", "legitEmail@csumb.edu", "password", "password"));
    }
    @Test
    public void invalidEmail() {
        assertEquals(false, SignUpActivity.validateSignUpInfo("Admin", "legitEmail@csumb.edu", "password", "passvard"));
    }


    @Test
    public void passwordsDontMatch() {
        assertEquals(false, SignUpActivity.validateSignUpInfo("Admin", "legitEmail@csumb.edu", "password", "passvard"));
    }

    @Test
    public void fieldsEmpty() {
        assertEquals(false, SignUpActivity.validateSignUpInfo("", "", "", ""));
    }

}