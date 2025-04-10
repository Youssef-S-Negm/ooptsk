package com.youssef.quiz.model;

import java.util.ArrayList;

public class Quiz {

    private final ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void displayQuestion(int questionIndex) {
        questions.get(questionIndex).display();
    }

    public int calculateScore(ArrayList<Integer> answers) {
        int score = 0;

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) == questions.get(i).getCorrectAnswerIndex())
                score++;
        }

        return score;
    }
}
