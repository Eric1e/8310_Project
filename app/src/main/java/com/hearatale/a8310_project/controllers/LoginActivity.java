package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.hearatale.a8310_project.R;

import model.User;
import model.Animal;
import model.UserList;

public class LoginActivity extends AppCompatActivity {
    private static UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button tigerButton = (Button) findViewById(R.id.tigerButton);
        tigerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onTigerButtonPressed(view);}
        });
    }

    public void onTigerButtonPressed(View view) {
        if(userList.check("Tiger")) {
            MainActivity.setUser(userList.getUser("Tiger"));
            MainActivity.setUserList(userList);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
