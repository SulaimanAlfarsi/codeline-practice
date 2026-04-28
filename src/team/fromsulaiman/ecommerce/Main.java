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

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    cart.addItem(new Product(name, price), qty);
                }
                else if (choice == 2) {
                    cart.viewCart();
                }
                else if (choice == 3) {
                    System.out.println("Total: " + cart.getTotal());
                }
                else if (choice == 4) {
                    System.out.println("Goodbye!");
                    break;
                }


            }


        }
}
