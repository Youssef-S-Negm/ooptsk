package com.youssef.quiz.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuiz {

    @Test
    public void testCalculateScore() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("q1?", new String[]{"A", "B", "C", "D"}, 2));
        questions.add(new Question("q2?", new String[]{"A", "B", "C", "D"}, 1));

        Quiz quiz = new Quiz(questions);

        ArrayList<Integer> answers = new ArrayList<>();

        answers.add(1);
        answers.add(1);

        int score = quiz.calculateScore(answers);

        assertEquals(1, score);
    }
}
