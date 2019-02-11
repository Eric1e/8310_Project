package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import com.hearatale.a8310_project.R;

import model.User;
import model.Animal;
import model.UserList;

public class LoginActivity extends AppCompatActivity {
    private static UserList userList;
    private ImageButton forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Button tigerButton = (Button) findViewById(R.id.tigerButton);
//        tigerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {onTigerButtonPressed(view);}
//        });

        forward = (ImageButton) findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategories();
            }
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

    public void onChickenClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Chicken");
        forward.setVisibility(View.VISIBLE);
    }

    public void onDuckClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Duck");
        forward.setVisibility(View.VISIBLE);
    }

    public void onHorseClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Horse");
        forward.setVisibility(View.VISIBLE);
    }

    public void onKoalaClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Koala");
        forward.setVisibility(View.VISIBLE);
    }

    public void onMonkeyClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Monkey");
        forward.setVisibility(View.VISIBLE);
    }

    public void onMouseClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Mouse");
        forward.setVisibility(View.VISIBLE);
    }

    public void onPandaClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Panda");
        forward.setVisibility(View.VISIBLE);
    }

    public void onUnicornClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Unicorn");
        forward.setVisibility(View.VISIBLE);
    }

    public void onTurtleClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Turtle");
        forward.setVisibility(View.VISIBLE);
    }

    public void onSnailClick(View v) {
        TextView txt = findViewById(R.id.name);
        txt.setText("Snail");
        forward.setVisibility(View.VISIBLE);
    }

    public void openCategories() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
