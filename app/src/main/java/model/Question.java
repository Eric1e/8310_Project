package model;

import java.util.ArrayList;

public class Question {
    private String text;
    private ArrayList<String> answers;
    private String audio_file;

    public Question(String audio_file, String question_text) {
        this.audio_file = audio_file;
        this.text = "";
        this.answers.add("");
    }

    public String getText() {
        return this.text;
    }
    public ArrayList<String> getAnswers() {
        return this.answers;
    }
}
