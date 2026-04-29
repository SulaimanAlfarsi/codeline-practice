package team.fromsulaiman.quizSystem;

import team.fromsulaiman.quizSystem.model.Question;
import team.fromsulaiman.quizSystem.model.Quiz;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Quiz System ===");

        Quiz quiz = new Quiz();

        Question q1 = new Question(
                "What is OOP?",
                Arrays.asList("Object Oriented Programming", "Only One Program", "Open Online Project"),
                "Object Oriented Programming"
        );

        Question q2 = new Question(
                "Which keyword is used to create a class in Java?",
                Arrays.asList("method", "class", "object"),
                "class"
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        System.out.println("Quiz created with " + quiz.getQuestions().size() + " questions.");

        scanner.close();
    }
}