package com.hearatale.a8310_project.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hearatale.a8310_project.R;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import model.FileManager;
import model.Media;

public class VideoListActivity extends AppCompatActivity {

    private RecyclerView videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_rhymes);
        videoList = findViewById(R.id.videoList);
        videoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        videoList.setAdapter(new VideoListAdapter(createMediaList()));
    }

    public ArrayList<Media> createMediaList() {
        ArrayList<Media> mediaList = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();

        try {
            for (Field field : fields) {
                String name = field.getName();
                if (!name.substring(0,1).equals("q")) {
                    Media media = new Media(Integer.toString(field.getInt(field)));
                    mediaList.add(media);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mediaList;
    }

    public void onHomeClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

}
