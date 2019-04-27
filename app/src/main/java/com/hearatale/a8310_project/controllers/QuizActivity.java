package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import com.hearatale.a8310_project.R;

import model.Question;
import model.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

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

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        Uri uri = Uri.parse("android.resource://com.hearatale.a8310_project/"+R.raw.question_001);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();

        // need to instantiate both the quiz and associated questions here
//        Quiz quiz = new Quiz();
//        for (Question q : quiz.getQuestions()) {
//            ArrayList<String> temp_answers = q.getAnswers();
//            Collections.shuffle(temp_answers);
//            updateView(q.getText(), temp_answers, q.getAnswers().get(0));
//        }
    }

    public void onHomeClick(View v) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View v) {
        Intent intent = new Intent(this, PlayVideoActivity.class);
        startActivity(intent);
    }

//    public void updateView(String text, ArrayList<String> answers, String answer) {
//        TextView question = findViewById(R.id.question);
//        question.setText(text);
//        answer1.setText(answers.get(0));
//        answer2.setText(answers.get(1));
//        answer3.setText(answers.get(2));
//        answer4.setText(answers.get(3));
//    }
}
