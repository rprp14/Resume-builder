package hms;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    String[] options;
    int correctAnswerIndex;

    public QuizQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

class Quiz {
    private QuizQuestion[] questions;
    private int score = 0;
    private int currentQuestionIndex = 0;
    private Scanner scanner = new Scanner(System.in);
    private Timer timer = new Timer();

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
    }

    public void start() {
        System.out.println("Welcome to the Quiz!");
        askQuestion();
    }

    private void askQuestion() {
        if (currentQuestionIndex < questions.length) {
            QuizQuestion question = questions[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + question.question);
            for (int i = 0; i < question.options.length; i++) {
                System.out.println((i + 1) + ". " + question.options[i]);
            }

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    checkAnswer(-1);  // Timeout, treat as incorrect answer
                }
            }, 10000);  // 10 seconds timer

            System.out.print("Your answer (1-" + question.options.length + "): ");
            int answer = scanner.nextInt();
            timer.cancel();
            checkAnswer(answer - 1);
        } else {
            showResults();
        }
    }

    private void checkAnswer(int answerIndex) {
        QuizQuestion question = questions[currentQuestionIndex];
        if (answerIndex == question.correctAnswerIndex) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer was: " + question.options[question.correctAnswerIndex]);
        }
        currentQuestionIndex++;
        timer = new Timer();  // Reset timer for next question
        askQuestion();
    }

    private void showResults() {
        System.out.println("\nQuiz over! Your score: " + score + "/" + questions.length);
    }
}

public class CodsoftTask4 {
    public static void main(String[] args) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, 2),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, 1),
            new QuizQuestion("Who wrote 'To Kill a Mockingbird'?", new String[] {"Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"}, 0),
            // Add more questions as needed
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
