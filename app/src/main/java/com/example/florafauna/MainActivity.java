package com.example.florafauna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Dummy validation, replace with actual login logic
                if (isValidCredentials(username, password)) {
                    // Login successful, navigate to main activity
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Invalid credentials, show error message
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isValidCredentials(String username, String password) {
        // Dummy validation, replace with actual login logic (e.g., check against database)
        return username.equals("admin") && password.equals("admin123");
    }


}