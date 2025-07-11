package com.Game.quizGame;

import junit.framework.TestCase;
import java.util.Arrays;

public class GameTest extends TestCase {

    public void testEvaluateAnswers_AllCorrect() {
        int score = Game.evaluateAnswers(Arrays.asList(
            "Paris", "James Gosling", "4", "extends", "Java Virtual Machine"
        ));
        assertEquals(5, score);
    }

    public void testEvaluateAnswers_SomeWrong() {
        int score = Game.evaluateAnswers(Arrays.asList(
            "Paris", "Someone else", "8", "extends", "Wrong"
        ));
        assertEquals(2, score);
    }

    public void testEvaluateAnswers_CaseInsensitive() {
        int score = Game.evaluateAnswers(Arrays.asList(
            "paris", "JAMES GOSLING", "4", "EXTENDS", "java virtual machine"
        ));
        assertEquals(5, score);
    }

    public void testEvaluateAnswers_LessThanFive() {
        int score = Game.evaluateAnswers(Arrays.asList("Paris", "James Gosling"));
        assertEquals(2, score);
    }
}
