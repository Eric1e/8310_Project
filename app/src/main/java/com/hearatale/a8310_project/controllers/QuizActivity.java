package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hearatale.a8310_project.R;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Uri uri = Uri.parse("android.resource://com.hearatale.a8310_project/"+R.raw.question_001);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
    }

    public void onHomeClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View v) {
        Intent intent = new Intent(this, PlayVideoActivity.class);
        startActivity(intent);
    }
}
