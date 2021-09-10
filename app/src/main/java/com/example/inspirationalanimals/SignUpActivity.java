package com.example.inspirationalanimals;

import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpActivity extends AppCompatActivity {

    private TextView errorMessage;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText passwordVerify;
    private Button btnSignUp;
    private static AppDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = AppDB.getInstance(this);
        database.seed();

        errorMessage = findViewById(R.id.errorMessage);
        username = findViewById(R.id.signUpUsername);
        email = findViewById(R.id.signUpEmail);
        password = findViewById(R.id.signUpPassword);
        passwordVerify = findViewById(R.id.signUpPasswordVerify);
        btnSignUp = findViewById((R.id.btnSignUp));


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int bgColor = android.R.color.background_light;

                errorMessage.setText("");
                errorMessage.setBackgroundColor(getResources().getColor(bgColor));

                boolean validInfo = validateSignUpInfo(errorMessage, username.getText().toString(), email.getText().toString(), password.getText().toString(), passwordVerify.getText().toString());
                Toast toast;
                if (!validInfo){
                    toast = Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_LONG);
                }
                else {
                    toast = Toast.makeText(getApplicationContext(), "Sign up successful", Toast.LENGTH_LONG);
                    loadHomeActivity(view, username.getText().toString());
                }
                toast.show();
            }
        });

    }

    protected static boolean validateSignUpInfo(TextView errorMessage, String username, String email, String password, String passwordVerify) {

        String usernameErrorMessage = verifyUsername(username);
        String emailErrorMessage = verifyEmail(email);
        String passwordErrorMessage = verifyPassword(password, passwordVerify);

        if (usernameErrorMessage.isEmpty() && emailErrorMessage.isEmpty() && passwordErrorMessage.isEmpty()) {
            database.addUser(username, password, email);
            return true;
        } else {
            errorMessage.setText(String.format("Error: %s%s%s", usernameErrorMessage, emailErrorMessage, passwordErrorMessage));
            errorMessage.setBackgroundColor(parseColor("#f55159"));
            return false;
        }
    }

    public static String verifyUsername(String username){
        String usernameError = "";
        if (username.length() == 0) {
            usernameError += "Username is empty. ";
        } else if (username.length() > 20) {
            usernameError += "Username is too long. ";
        } else {
            List<User> existingUsers = database.getAllUsers();

            for (User user : existingUsers) {
                if (username.equals(user.getUsername())) {
                    usernameError += "Username already in use. ";
                    break;
                }
            }
        }

        return usernameError;
    }

    public static String verifyEmail(String email){
        String emailError = "";

        Pattern p = Pattern.compile(".+@.*[A-Za-z]+\\.[A-Za-z]+");
        Matcher m = p.matcher(email);

        if (email.length() == 0) {
            emailError += "Email is empty. ";
        } else if (!m.matches()) {
            emailError += "Email is not valid. ";
        }
        else {
            List<User> existingUsers = database.getAllUsers();

            for (User user : existingUsers) {
                if (emailError.equals(user.getEmail())) {
                    emailError += "Email already in use. ";
                    break;
                }
            }
        }

        return emailError;
    }

    public static String verifyPassword(String password, String passwordVerify){
        String passwordError = "";

        if (password.length() == 0) {
            passwordError += "Password is empty. ";
        } else if (password.length() < 6) {
            passwordError += "Password is too short. ";
        }
        else if (!password.equals(passwordVerify)) {
            passwordError += "Passwords do not match. ";
        }

        return passwordError;
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }

    private void loadHomeActivity(View view, String username) {
        Intent intent = HomeActivity.getIntent(getApplicationContext());
        intent.putExtra("CURRENT_USERNAME", username);
        startActivity(intent);

    }
}