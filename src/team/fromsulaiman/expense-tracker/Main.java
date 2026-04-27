import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Expense Tracker ===");

        while (running) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. Filter by Category");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    Expense expense = new Expense(desc, amount, category, date);
                    manager.addExpense(expense);
                    System.out.println("Expense added!");
                    break;
                case "2":
                    manager.viewAllExpenses();
                    break;
                case "3":
                    System.out.println("Total Spending: $" + manager.getTotalExpenses());
                    break;
                case "4":
                    System.out.print("Enter category: ");
                    String cat = scanner.nextLine();
                    manager.filterByCategory(cat);
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}