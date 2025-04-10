package com.youssef.quiz.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {

    @Test
    public void testName() {
        User user = new User("test");
        String name = user.getName();

        assertEquals("test", name);
    }

    @Test
    public void testRecordedAnswers() {
        User user = new User("test");

        user.recordAnswer(1);
        user.recordAnswer(2);

        assertEquals(Arrays.asList(1, 2), user.getAnswers());
    }
}
