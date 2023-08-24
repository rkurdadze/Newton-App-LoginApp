package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReActivity extends AppCompatActivity {

    private EditText userText, passText, passText2;
    private Button confirmBtn;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re);

        userText = findViewById(R.id.userReText);
        passText = findViewById(R.id.passReText);
        passText2 = findViewById(R.id.passReText2);
        confirmBtn = findViewById(R.id.confirmBtn);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pass, pass2 = "";
                user = userText.getText().toString();
                pass = passText.getText().toString();
                pass2 = passText2.getText().toString();
                if (!user.isEmpty() && !pass.isEmpty() && (pass.equals(pass2)))
                {
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                    sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
                    editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
                    if (sharedPref.getString("user", null) == null) {
                        editor.putString("user", user);
                    }
                    editor.putString("pass", pass);
                    editor.commit();
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}