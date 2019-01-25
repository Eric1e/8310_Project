package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hearatale.a8310_project.R;
import model.User;
import model.UserList;

public class MainActivity extends AppCompatActivity {
    private static User user;
    private static UserList userList;
    private ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // go to the login page when play button is pressed
        play = (ImageButton) findViewById(R.id.Play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    public void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public static User getUser() {return user;}

    public static void setUser(User newUser) {user = newUser;}

    public static UserList getUserList() {return userList;}

    public static void setUserList(UserList newUserList) {userList = newUserList;}
}
