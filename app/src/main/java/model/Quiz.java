package model;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;

    public Quiz(String audio_file, String question_text) {
        Question question = new Question(audio_file, question_text);
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
}
