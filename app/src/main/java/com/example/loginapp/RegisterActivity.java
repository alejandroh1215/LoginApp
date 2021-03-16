package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    EditText fname, lname, dateofbirth, email, password;      // these are to declare the inputs and the button on the Activity page
    Button rbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname =findViewById(R.id.fname);                     //here we match them to the id
        lname =findViewById(R.id.lname);
        dateofbirth =findViewById(R.id.dateofbirth);
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        rbutton =findViewById(R.id.rbutton);

        rbutton.setOnClickListener(new View.OnClickListener() {     //listener for register button in activity
            @Override
            public void onClick(View v) {
                checkDataEntered();                    //call for a function to check if the fields are empty
                finishReg();
            }
        });
    }
    boolean isEmpty(EditText text){        //method to check if the EditText is empty, we will use it in the checkdataEntered function
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean validatelength(EditText text){  //check for 3 to 30 characters
        CharSequence str = text.getText().toString();
        if (str.length()<3 || str.length()>30) {
            return true;
        }
        else{
            return false;
        }
    }
    void checkDataEntered(){   //here i will declare if statements to return errors in each field for mistakes
        if (isEmpty(fname) || validatelength(fname)){ //declared or function to check both empty or correct length
            fname.setError("A valid First Name is required (between 3 to 30 characters)");
        }
        if (isEmpty(lname) || validatelength(lname)){
            lname.setError("A valid Last Name is required (between 3 to 30 characters)");
        }
        if (isEmpty(dateofbirth)){
            dateofbirth.setError("A valid Date of Birth is required (mm/dd/yyyy or 12/31/2001");
        }
        if (isEmpty(email)){
            email.setError("A valid Email is required (ex: johndoe@mail.com)");
        }
        if (isEmpty(password)){
            password.setError("A valid password is required");
        }
    }
    void finishReg(){ //here we check all to be right if not return toast, if it is all filled in correctly return to Home
        if(isEmpty(fname) || isEmpty(lname) || isEmpty(dateofbirth) || isEmpty(email) || isEmpty(password) || validatelength(fname) || validatelength(lname)){
            Toast t = Toast.makeText(this,"Please check your form and fill out missing or incorrect fields!", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            Intent homeAct = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(homeAct);
            Toast t = Toast.makeText(this,"You have successfully registered! \n Thank you!", Toast.LENGTH_LONG);
            t.show();
        }
    }
}