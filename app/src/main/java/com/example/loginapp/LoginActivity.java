package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userText, passText;
    private Button loginBtn;
    private Button reBtn;

    private SharedPreferences sharedPref;
    private String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userText = findViewById(R.id.userText);
        passText = findViewById(R.id.passText);
        loginBtn = findViewById(R.id.loginBtn);
        reBtn = findViewById(R.id.reBtn);

        sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
        user = sharedPref.getString("user", null);
        pass = sharedPref.getString("pass", null);
        if (user == null || pass == null)
        {
            Intent reAct = new Intent(getApplicationContext(), ReActivity.class);
            startActivity(reAct);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userText.getText().toString().equals(user) && passText.getText().toString().equals(pass))
                {
                    Intent defAct = new Intent(getApplicationContext(), DefaultActivity.class);
                    startActivity(defAct);
                }
                else Toast.makeText(getApplicationContext(), "Incorrect user/pass", Toast.LENGTH_LONG).show();
            }
        });

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reAct = new Intent(getApplicationContext(), ReActivity.class);
                startActivity(reAct);
            }
        });
    }
}