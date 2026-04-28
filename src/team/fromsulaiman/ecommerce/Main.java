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
                String name;

                while (true) {
                    System.out.print("Name: ");
                    name = scanner.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty.");
                    } else {
                        break;
                    }
                }

                double price;

                while (true) {
                    System.out.print("Price: ");
                    try {
                        price = scanner.nextDouble();

                        if (price <= 0) {
                            System.out.println("Price must be positive.");
                            continue;
                        }

                        break;

                    } catch (Exception e) {
                        System.out.println("Invalid number.");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();

                int qty;

                while (true) {
                    System.out.print("Quantity: ");
                    try {
                        qty = scanner.nextInt();

                        if (qty <= 0) {
                            System.out.println("Quantity must be greater than 0.");
                            continue;
                        }

                        break;

                    } catch (Exception e) {
                        System.out.println("Invalid number.");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();
            }

        }
}
