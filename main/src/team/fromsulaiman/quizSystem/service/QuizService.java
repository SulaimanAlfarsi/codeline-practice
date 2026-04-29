package team.fromsulaiman.quizSystem.service;
import team.fromsulaiman.quizSystem.util.InputUtil;

import team.fromsulaiman.quizSystem.model.Question;
import team.fromsulaiman.quizSystem.model.Quiz;

import java.util.Scanner;

public class QuizService {

    public void startQuiz(Quiz quiz, Scanner scanner) {
        int score = 0;

        for (Question question : quiz.getQuestions()) {
            question.display();

            int answerNumber = InputUtil.getValidOption(scanner, question.getOptions().size());

            String selectedAnswer = question.getOptions().get(answerNumber - 1);

            if (selectedAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
                System.out.println("Correct answer: " + question.getCorrectAnswer());
            }

            System.out.println();
        }

        System.out.println("=== Quiz Finished ===");
        System.out.println("Your final score: " + score + "/" + quiz.getQuestions().size());
    }
}