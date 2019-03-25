package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hearatale.a8310_project.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void onMotherClick(View view) {
        Intent intent = new Intent(this, VideoListActivity.class);
        intent.putExtra("category", "m_");
        intent.putExtra("title", "Mother Goose");
        startActivity(intent);
    }

    public void onFatherClick(View view) {
        Intent intent = new Intent(this, VideoListActivity.class);
        intent.putExtra("category", "f_");
        intent.putExtra("title", "Father Goose");
        startActivity(intent);
    }
}
