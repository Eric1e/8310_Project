package com.hearatale.a8310_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hearatale.a8310_project.R;
import model.User;
import model.UserList;

public class MainActivity extends AppCompatActivity {
    private static User user;
    private static UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static User getUser() {return user;}

    public static void setUser(User newUser) {user = newUser;}

    public static UserList getUserList() {return userList;}

    public static void setUserList(UserList newUserList) {userList = newUserList;}
}
