package com.youssef.quiz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuestion {

    @Test
    public void testCorrectIndex() {
        Question question = new Question("q?", new String[]{"A", "B", "C", "D"}, 2);

        assertEquals(2, question.getCorrectAnswerIndex());
    }
}
