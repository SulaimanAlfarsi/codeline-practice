package team.fromsulaiman.quizSystem;

import team.fromsulaiman.quizSystem.model.Question;
import team.fromsulaiman.quizSystem.model.Quiz;
import team.fromsulaiman.quizSystem.service.QuizService;
import team.fromsulaiman.quizSystem.util.InputUtil;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Quiz System ===");

        Quiz quiz = new Quiz();

// Add many questions using one list
        quiz.addQuestion(new Question(
                "What is OOP?",
                Arrays.asList("Object Oriented Programming", "Only One Program", "Open Online Project"),
                "Object Oriented Programming"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used to create a class in Java?",
                Arrays.asList("method", "class", "object"),
                "class"
        ));

        quiz.addQuestion(new Question(
                "Which data type stores text?",
                Arrays.asList("int", "String", "boolean"),
                "String"
        ));

        quiz.addQuestion(new Question(
                "Which loop repeats a fixed number of times?",
                Arrays.asList("for", "while", "if"),
                "for"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used for inheritance?",
                Arrays.asList("extends", "implements", "inherits"),
                "extends"
        ));

        quiz.addQuestion(new Question(
                "Which symbol is used for comments in Java?",
                Arrays.asList("//", "##", "--"),
                "//"
        ));

        quiz.addQuestion(new Question(
                "Which method is the entry point of Java?",
                Arrays.asList("main", "start", "run"),
                "main"
        ));

        quiz.addQuestion(new Question(
                "Which keyword creates an object?",
                Arrays.asList("new", "create", "make"),
                "new"
        ));

        quiz.addQuestion(new Question(
                "Which access modifier is most restrictive?",
                Arrays.asList("public", "private", "protected"),
                "private"
        ));

        quiz.addQuestion(new Question(
                "Which collection stores dynamic arrays?",
                Arrays.asList("ArrayList", "HashMap", "Set"),
                "ArrayList"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used to define a constant?",
                Arrays.asList("final", "const", "static"),
                "final"
        ));

        quiz.addQuestion(new Question(
                "Which operator compares values?",
                Arrays.asList("==", "=", "!="),
                "=="
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used for exception handling?",
                Arrays.asList("try", "catch", "throw"),
                "try"
        ));

        quiz.addQuestion(new Question(
                "Which block is always executed?",
                Arrays.asList("finally", "try", "catch"),
                "finally"
        ));

        quiz.addQuestion(new Question(
                "Which interface is used for lists?",
                Arrays.asList("List", "Map", "Set"),
                "List"
        ));

        quiz.addQuestion(new Question(
                "Which keyword stops a loop?",
                Arrays.asList("break", "stop", "exit"),
                "break"
        ));

        quiz.addQuestion(new Question(
                "Which keyword skips iteration?",
                Arrays.asList("continue", "skip", "pass"),
                "continue"
        ));

        quiz.addQuestion(new Question(
                "Which method prints output?",
                Arrays.asList("System.out.println", "print()", "echo"),
                "System.out.println"
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used for interfaces?",
                Arrays.asList("interface", "class", "abstract"),
                "interface"
        ));

        quiz.addQuestion(new Question(
                "Which type is used for true/false?",
                Arrays.asList("boolean", "int", "String"),
                "boolean"
        ));


        QuizService quizService = new QuizService();

        boolean playAgain = true;

        while (playAgain) {
            quiz.shuffleQuestions();
            quizService.startQuiz(quiz, scanner);

            playAgain = InputUtil.askYesNo(scanner, "Do you want to play again? (yes/no): ");
        }

        System.out.println("Thank you for playing!");

        scanner.close();
    }
}