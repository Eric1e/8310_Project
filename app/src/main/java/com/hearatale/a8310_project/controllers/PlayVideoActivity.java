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

        final VideoView mVideoView = findViewById(R.id.videoView);
        mVideoView.setVideoURI(FileManager.getInstance().getSelectedVideo());
        mVideoView.requestFocus();
        mVideoView.start();

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
        Intent intent = new Intent(this, VideoListActivity.class);
        startActivity(intent);
    }
}
