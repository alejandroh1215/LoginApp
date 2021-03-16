package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonOne = findViewById(R.id.registerbutton);
        buttonOne.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Intent registerAct = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(registerAct);
            }
        });

        Button buttonTwo = findViewById(R.id.loginbutton);
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent LoginAct = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(LoginAct);
            }
        });

    }
}