package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hearatale.a8310_project.R;

import model.Question;
import model.Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private CardView card1, card2, card3, card4;
    private ImageButton next_question;
    private Quiz quiz;
    private int rhyme_number = 1;
    private int answer_number;
    private int question_index;

    public void fade1() {
        card1.animate().alpha(0f).setDuration(2000);
    }

    public void fade2() {
        card2.animate().alpha(0f).setDuration(2000);
    }

    public void fade3() {
        card3.animate().alpha(0f).setDuration(2000);
    }

    public void fade4() {
        card4.animate().alpha(0f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        next_question = findViewById(R.id.next_question);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);
        next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateView();
            }
        });

        InputStream is = getResources().openRawResource(R.raw.quizzes);
        //StringBuilder build = new StringBuilder();
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<Integer> audio_files = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = buff.readLine()) != null) {
                if (line.length() >= 3 && line.substring(0, 3).equals("[V]") && Integer.parseInt(line.substring(4)) == rhyme_number){
                    while (!((line = buff.readLine()).substring(0, 1).equals("1"))) {}
                    questions.add(line.substring(3));
                    while (!((line = buff.readLine()).substring(0, 1).equals("["))) {
                        answers.add(line);
                        if ((line = buff.readLine()).substring(0, 1).equals("[")) {
                            break;
                        }
                        questions.add(line.substring(3));
                    }
                    break;
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {is.close();} catch (Throwable ignore) {}
        }
        audio_files.add(R.raw.question_001);
        audio_files.add(R.raw.question_002);
        audio_files.add(R.raw.question_003);
        audio_files.add(R.raw.question_004);
        quiz = new Quiz(audio_files, questions, answers);
        question_index = 0;
        updateView();
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
        Intent intent = new Intent(this, PlayVideoActivity.class);
        intent.putExtra("category", pre);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    public void updateView() {
        if (question_index >= quiz.getQuestions().size()) {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        }
        next_question.setVisibility(View.INVISIBLE);
        Question q = quiz.getQuestions().get(question_index);
        Uri uri = Uri.parse("android.resource://com.hearatale.a8310_project/"+q.getAudio());
        ArrayList<String> temp_answers = new ArrayList<>(Arrays.asList(q.getAnswers()));
        Collections.shuffle(temp_answers);
        answer_number = temp_answers.indexOf(q.getAnswers()[0]);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, uri);
        TextView question = findViewById(R.id.question);
        question.setText(q.getText());
        card1.setAlpha(1f);
        card2.setAlpha(1f);
        card3.setAlpha(1f);
        card4.setAlpha(1f);
        answer1.setText(temp_answers.get(0));
        answer2.setText(temp_answers.get(1));
        answer3.setText(temp_answers.get(2));
        answer4.setText(temp_answers.get(3));
        mediaPlayer.start();
        question_index++;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.answer1:
                if (answer_number == 0) {
                    answer1.setText("Correct!");
                    fade2();
                    fade3();
                    fade4();
                    next_question.setVisibility(View.VISIBLE);
                } else {
                    answer1.setText("That's wrong, \ntry again!");
                }
                break;

            case R.id.answer2:
                if (answer_number == 1) {
                    answer2.setText("Correct!");
                    fade1();
                    fade3();
                    fade4();
                    next_question.setVisibility(View.VISIBLE);
                } else {
                    answer2.setText("That's wrong, \ntry again!");
                }
                break;

            case R.id.answer3:
                if (answer_number == 2) {
                    answer3.setText("Correct!");
                    fade1();
                    fade2();
                    fade4();
                    next_question.setVisibility(View.VISIBLE);
                } else {
                    answer3.setText("That's wrong, \ntry again!");
                }
                break;

            case R.id.answer4:
                if (answer_number == 3) {
                    answer4.setText("Correct!");
                    fade1();
                    fade2();
                    fade3();
                    next_question.setVisibility(View.VISIBLE);
                } else {
                    answer4.setText("That's wrong, \ntry again!");
                }
                break;

            default:
                break;
        }

    }
}