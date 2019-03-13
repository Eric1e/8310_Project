package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hearatale.a8310_project.R;

public class QuizActivity extends AppCompatActivity {

    public void fade1(View view) {
        CardView card1 = findViewById(R.id.card1);
        card1.animate().alpha(0f).setDuration(2000);
    }

    public void fade2(View view) {
        CardView card2 = findViewById(R.id.card2);
        card2.animate().alpha(0f).setDuration(2000);
    }

    public void fade3(View view) {
        CardView card3 = findViewById(R.id.card3);
        card3.animate().alpha(0f).setDuration(2000);
    }

    public void fade4(View view) {
        CardView card4 = findViewById(R.id.card4);
        card4.animate().alpha(0f).setDuration(2000);
    }

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
