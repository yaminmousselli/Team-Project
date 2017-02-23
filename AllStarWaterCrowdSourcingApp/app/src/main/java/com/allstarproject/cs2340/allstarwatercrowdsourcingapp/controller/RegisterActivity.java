package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model
        .MySQLiteHelper;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model
        .RegisteredUserDB;


import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;

public class RegisterActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText emailText;
    Spinner accountType;
    EditText usernameText;
    EditText passwordText;
    EditText lastNameText;
    MySQLiteHelper db = new MySQLiteHelper(this);
    /**
     * onCreate used to setup RegisterActivity on creation
     * @param savedInstanceState is bundled data passed in to use at creation
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRCancel = (Button) findViewById(R.id.btnRCancel);
        btnRCancel.setOnClickListener(this);

        Button btnRSubmit = (Button) findViewById(R.id.btnSubmt);
        emailText = (EditText) findViewById(R.id.txtEmail);
        accountType = (Spinner) findViewById(R.id.accountTypeSpinner);
        usernameText = (EditText) findViewById(R.id.txtUserName);
        passwordText = (EditText) findViewById(R.id.txtPassword);
        lastNameText = (EditText) findViewById(R.id.txtName);
        btnRSubmit.setOnClickListener(this);
    }

    /**
     * onClick method to handle the cancel button being clicked by returning you to Welcome
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRCancel:
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSubmt:
                String email = emailText.getText().toString();
                String accountTypeText = accountType.getSelectedItem()
                        .toString();
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                String lastName = lastNameText.getText().toString();
                db.addRegisteredUserDB(new RegisteredUserDB(email,
                        accountTypeText, username, password, lastName));

                Intent intent2 = new Intent(RegisterActivity.this,
                        LoginActivity.class);
                startActivity(intent2);
        }
    }
}
