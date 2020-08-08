package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText edt_username;
    EditText edt_password;
    Button btn_forgetpass;
    Button btn_signin;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        btn_forgetpass = findViewById(R.id.btn_forgetpass);
        btn_signin = findViewById(R.id.btn_signin);
        btn_signup = findViewById(R.id.btn_signup);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_username.getText().toString().equalsIgnoreCase("Fino")&&
                        edt_password.getText().toString().equalsIgnoreCase("alvaro")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Recyclerview.class);
                    intent.putExtra("Username", edt_username.getText().toString());
                    startActivity(intent);
                } else {
                    edt_username.setError("Invalid Username");
                    edt_password.setError("Invalid Password");
                }
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, Registration.class);
                in.putExtra("Signup", btn_signup.getText().toString());
                startActivity(in);
            }
        });
    }
}