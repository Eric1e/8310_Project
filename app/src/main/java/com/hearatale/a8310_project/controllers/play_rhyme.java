package com.hearatale.a8310_project.controllers;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.hearatale.a8310_project.R;

public class play_rhyme extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_rhyme);

        VideoView mVideoView = (VideoView) findViewById(R.id.videoView);
        String uriPath = "android.resource://com.hearatale.a8310_project/"+R.raw.v1_oldmothergoose;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();
    }
}
