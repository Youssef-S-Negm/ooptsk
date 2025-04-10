package com.youssef.quiz.model;

import java.util.ArrayList;

public class User {
    private final String name;
    private final ArrayList<Integer> answers;

    public User(String name) {
        this.name = name;
        answers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public void recordAnswer(int answer) {
        answers.add(answer);
    }

}
