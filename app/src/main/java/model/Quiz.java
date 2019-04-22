package model;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(ArrayList<Integer> audio_files, ArrayList<String> question_text, ArrayList<String> answers_text) {
        for (int i = 0; i < question_text.size(); i++) {
            Question question = new Question(audio_files.get(i), question_text.get(i), answers_text.get(i));
            this.questions.add(question);
        }
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
}
