package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hearatale.a8310_project.R;

public class RhymesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhyme_list);
    }

    public void onRhymeClick(View view) {
        Intent intent = new Intent(this, play_rhyme.class);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
