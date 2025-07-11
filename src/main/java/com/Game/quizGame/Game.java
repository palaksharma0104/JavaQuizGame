package com.Game.quizGame;

import java.util.*;

public class Game {
	 private static class Question {
	        String question;
	        String answer;

	        Question(String question, String answer) {
	            this.question = question;
	            this.answer = answer.toLowerCase();
	        }

	        boolean checkAnswer(String userAnswer) {
	            return answer.equalsIgnoreCase(userAnswer.trim());
	        }
	    }

	    private static final Scanner scanner = new Scanner(System.in);
	    private static final List<Question> questionBank = new ArrayList<>();

	    static {
	        questionBank.add(new Question("What is the capital of France?", "Paris"));
	        questionBank.add(new Question("Who developed Java?", "James Gosling"));
	        questionBank.add(new Question("What is the size of int in Java?", "4"));
	        questionBank.add(new Question("Which keyword is used to inherit a class in Java?", "extends"));
	        questionBank.add(new Question("What does JVM stand for?", "Java Virtual Machine"));
	        questionBank.add(new Question("What is the default value of boolean in Java?", "false"));
	        questionBank.add(new Question("Which method is the entry point in Java?", "main"));
	        questionBank.add(new Question("How many data types do we have?", "8"));
	        questionBank.add(new Question("What is the parent class of all classes in Java?", "Object"));
	        questionBank.add(new Question("Which collection doesn’t allow duplicate elements?", "Set"));
	    }

	    public static void play() {
	        boolean continuePlaying = true;

	        while (continuePlaying) {
	            Collections.shuffle(questionBank);
	            int score = 0;

	            System.out.println("\n--- Welcome to the Java Quiz Game ---");
	            System.out.println("\n!!!!! Let's Start The Game !!!!!");
	            for (int i = 0; i < 5; i++) {
	                Question q = questionBank.get(i);
	                System.out.println("\nQ" + (i + 1) + ": " + q.question);
	                System.out.print("Your Answer: ");
	                String userAnswer = scanner.nextLine();

	                if (q.checkAnswer(userAnswer)) {
	                    System.out.println("Correct!");
	                    score++;
	                } else {
	                    System.out.println("Wrong! Correct answer: " + q.answer);
	                }
	            }

	            System.out.println("\n🎯 Your Score: " + score + "/5");

	            System.out.print("Do you want to play again? (yes/no): ");
	            String again = scanner.nextLine();
	            continuePlaying = again.equalsIgnoreCase("yes");
	        }

	        System.out.println("Thanks for playing! 🎉");
	    }

	    public static void main(String[] args) {
	        play();
	    }

	    // For testability
	    public static int evaluateAnswers(List<String> answers) {
	        int score = 0;
	        for (int i = 0; i < 5 && i < answers.size(); i++) {
	            if (questionBank.get(i).checkAnswer(answers.get(i))) {
	                score++;
	            }
	        }
	        return score;
	    }
	}


