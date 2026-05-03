package team.fromsulaiman.clinicSystem.util;

import java.util.Scanner;

public class InputHelper {
    private Scanner scanner = new Scanner(System.in);

    public String readText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public String readRequiredText(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine();

            if (!value.trim().isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}