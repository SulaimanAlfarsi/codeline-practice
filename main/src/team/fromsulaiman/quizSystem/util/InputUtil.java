package team.fromsulaiman.quizSystem.util;

import java.util.Scanner;

public class InputUtil {

    public static int getValidOption(Scanner scanner, int maxOption) {

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

            if (answerNumber < 1 || answerNumber > maxOption) {
                System.out.println("Please choose a number between 1 and " + maxOption);
                continue;
            }

            validInput = true;
        }

        return answerNumber;
    }
}