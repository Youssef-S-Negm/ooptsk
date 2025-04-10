package com.youssef.quiz.model;

public class Question {

    private final String text;
    private final String[] possibleAnswers;
    private final int correctAnswerIndex;

    public Question(String text, String[] possibleAnswers, int correctAnswerIndex) {
        this.text = text;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void display() {
        System.out.println(text);

        for (int i = 0; i < possibleAnswers.length; i++) {
            System.out.println(i + ". " + possibleAnswers[i]);
        }

        System.out.println("----------------------");
    }
}
