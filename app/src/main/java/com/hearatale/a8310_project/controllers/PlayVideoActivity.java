package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

import com.hearatale.a8310_project.R;

import model.FileManager;

public class PlayVideoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_rhyme);

        String title = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title");
        }

        ImageButton quizB = findViewById(R.id.quiz);
        if ("Mother Goose".equals(title)) {
            quizB.setVisibility(View.VISIBLE);
        }

        //Pull out video view and set the video, then auto play
        final VideoView mVideoView = findViewById(R.id.videoView);
        mVideoView.setVideoURI(FileManager.getInstance().getSelectedVideo());
        mVideoView.requestFocus();
        mVideoView.start();

        //Allows for replaying video from beginning
        ImageButton restart = findViewById(R.id.replay);
        restart.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.suspend();
                VideoView mVideoView2 = findViewById(R.id.videoView);
//                String uriPath = "android.resource://com.hearatale.a8310_project/"+R.raw.v1_oldmothergoose;
//                Uri uri = Uri.parse(uriPath);
                mVideoView2.setVideoURI(FileManager.getInstance().getSelectedVideo());
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });
    }

    public void onHomeClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View v) {
        String pre = "";
        String title = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pre = extras.getString("category");
            title = extras.getString("title");
        }
        Intent intent = new Intent(this, VideoListActivity.class);
        intent.putExtra("category", pre);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    public void onQuizClick(View v) {
        String pre = "";
        String title = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pre = extras.getString("category");
            title = extras.getString("title");
        }
        Intent intent = new Intent( this, QuizActivity.class);
        intent.putExtra("category", pre);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
