package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            printMenu();
            int choice = getChoice(scanner);
            processChoice(scanner, library, choice);
        }
    }

    private static void printMenu() {
        System.out.println("\n========== Library Menu ==========");
        System.out.println("1. Add Book");
        System.out.println("2. Show Available Books");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Show All Books");
        System.out.println("6. Show Statistics");
        System.out.println("7. Remove Book");
        System.out.println("8. Clear Library");
        System.out.println("9. Exit");
        System.out.print("Choose: ");
    }

    private static int getChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.println("Input cannot be empty.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    private static void processChoice(Scanner scanner, Library library, int choice) {
        scanner.nextLine();
        switch (choice) {
                case 1:
                    String title = getInput(scanner, "Enter title: ");
                    String author = getInput(scanner, "Enter author: ");
                    library.addBook(new Book(title, author));
                    System.out.println("Book added.");
                    break;
                case 2:
                    library.showAvailableBooks();
                    break;
                case 3:
                    String borrowTitle = getInput(scanner, "Enter book title to borrow: ");
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    String returnTitle = getInput(scanner, "Enter book title to return: ");
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    library.showAllBooks();
                    break;
                case 6:
                    System.out.println("Total books: " + library.getBookCount());
                    System.out.println("Available books: " + library.getAvailableCount());
                    break;
                case 7:
                    String removeTitle = getInput(scanner, "Enter book title to remove: ");
                    library.removeBook(removeTitle);
                    break;
                case 8:
                    library.clear();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}