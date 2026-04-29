package team.fromsulaiman.quizSystem.service;

import team.fromsulaiman.quizSystem.model.Question;
import team.fromsulaiman.quizSystem.model.Quiz;

import java.util.Scanner;

public class QuizService {

    public void startQuiz(Quiz quiz, Scanner scanner) {
        int score = 0;

        for (Question question : quiz.getQuestions()) {
            question.display();

            int answerNumber = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Choose option number: ");
                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {
                    System.out.println("Answer cannot be empty.");
                    continue;
                }

                try {
                    answerNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                if (answerNumber < 1 || answerNumber > question.getOptions().size()) {
                    System.out.println("Please choose a number between 1 and " + question.getOptions().size());
                    continue;
                }

                validInput = true;
            }

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