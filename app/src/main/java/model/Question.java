package model;

import java.util.ArrayList;

public class Question {
    private String text;
    private String[] answers;
    private Integer audio_file;

    public Question(Integer audio_file, String question_text, String answers_text) {
        this.audio_file = audio_file;
        this.text = question_text;
        for (int i = 0; i < 4; i++) {
            answers = answers_text.split(" ");
        }
    }

    public String getText() {
        return this.text;
    }
    public String[] getAnswers() {
        return this.answers;
    }
    public Integer getAudio() { return this.audio_file;}
}
