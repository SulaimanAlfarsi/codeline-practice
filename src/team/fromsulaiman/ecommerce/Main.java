package fromsulaiman.ecommerce;
import java.util.Scanner;


public class Main {
        public static void main(String[] args) {
            Cart cart = new Cart();
            Scanner scanner = new Scanner(System.in);



            while (true) {
                System.out.println("\n1. Add Product");
                System.out.println("2. View Cart");
                System.out.println("3. Total");
                System.out.println("4. Exit");
                System.out.print("Choose: ");

                int choice;

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                if (choice == 1) {

                }
                else if (choice == 2) {

                }
                else if (choice == 3) {

                }
                else if (choice == 4) {
                    System.out.println("Goodbye!");
                    break;
                }
                else {
                    System.out.println("Invalid choice");
                }

            }

        }
}
