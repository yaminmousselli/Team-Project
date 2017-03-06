package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.content.Intent;
<<<<<<< HEAD

=======
import android.widget.TextView;
>>>>>>> 7961ba36abab20ef9cea0ed94e7feae707b4f344

import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.R;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.Model;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.RegisteredUser;
import com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model.*;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Model model = Model.getInstance();
    Spinner spinner;
    EditText txtUserName;
    EditText txtName;
    EditText txtEmail;
    EditText txtPassword;
    EditText txtConfPassword;

<<<<<<< HEAD
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

<<<<<<< HEAD
        Button btnRCancel = (Button) findViewById(R.id.btnRCancel);
        btnRCancel.setOnClickListener(this);

        Button btnRSubmit = (Button) findViewById(R.id.btnSubmt);
        emailText = (EditText) findViewById(R.id.txtEmail);
        accountType = (Spinner) findViewById(R.id.accountTypeSpinner);
        usernameText = (EditText) findViewById(R.id.txtUserName);
        passwordText = (EditText) findViewById(R.id.txtPassword);
        lastNameText = (EditText) findViewById(R.id.txtName);
        btnRSubmit.setOnClickListener(this);
=======
        txtUserName = (EditText) findViewById(R.id.txtCurrentName);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfPassword = (EditText) findViewById(R.id.txtConfPassword);

        spinner = (Spinner) findViewById(R.id.spinner);

        Button btnRCancel = (Button) findViewById(R.id.btnCancelRegister);
        btnRCancel.setOnClickListener(this);
        Button btnSubmitRegister = (Button) findViewById(R.id.btnSubmitRegister);
        btnSubmitRegister.setOnClickListener(this);
>>>>>>> 7961ba36abab20ef9cea0ed94e7feae707b4f344
    }

    /**
     * onClick method to handle the cancel button being clicked by returning you to Welcome
     * @param v the current view
     */
    @Override
    public void onClick(View v) {
<<<<<<< HEAD
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
=======
        switch(v.getId()) {
           case R.id.btnCancelRegister:
               Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
               startActivity(intent);
               break;

            case R.id.btnSubmitRegister:
                Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                if (txtConfPassword.getText().toString().equals(txtPassword.getText().toString())) {
                    if (spinner.getSelectedItem() == "User") {
                        new RegisteredUser(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else if (spinner.getSelectedItem() == "Manager") {
                        new Manager(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else if (spinner.getSelectedItem() == "Worker") {
                        new Worker(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    } else {
                        new Admin(txtUserName.getText().toString()
                                , txtPassword.getText().toString(), txtName.getText().toString()
                                ,txtEmail.getText().toString());
                    }
                    startActivity(intent2);

                } else {
                    TextView textView = (TextView) findViewById(R.id.txtlbl);
                    textView.setText("Passwords do not match");
                }

                break;
>>>>>>> 7961ba36abab20ef9cea0ed94e7feae707b4f344
        }
    }
}
