package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emaillogin, passwordlogin;      // these are to declare the inputs and the button on the Activity page
    Button lbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emaillogin =findViewById(R.id.emaillogin);                    //Edit texts on our login page
        passwordlogin =findViewById(R.id.passwordlogin);
        lbutton = findViewById(R.id.lbutton);

        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishLogin();   //to complete login we call this function
            }
        });
    }
    boolean isEmpty(EditText text){        //method to check if the EditText is empty, grabbed it from my register activity
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void finishLogin(){  //our function to check the fields and complete the login
        if( isEmpty(emaillogin) || isEmpty(passwordlogin) ){
            Toast t = Toast.makeText(this,"Please check your login information!", Toast.LENGTH_SHORT);
            t.show();
            emaillogin.setError("");
            passwordlogin.setError("");
        }
        else{
            Intent homeAct = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(homeAct);
            Toast t = Toast.makeText(this,"You have successfully logged in! \n Thank you!", Toast.LENGTH_LONG);
            t.show();
        }
    }
}