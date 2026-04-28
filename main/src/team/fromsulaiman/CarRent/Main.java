package team.fromsulaiman.CarRent;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. View History");
            System.out.println("6. Exit");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {

                String id;
                while (true) {
                    System.out.print("Car ID: ");
                    id = scanner.nextLine();

                    if (id.trim().isEmpty()) {
                        System.out.println("ID cannot be empty.");
                    } else {
                        break;
                    }
                }

                String model;
                while (true) {
                    System.out.print("Model: ");
                    model = scanner.nextLine();

                    if (model.trim().isEmpty()) {
                        System.out.println("Model cannot be empty.");
                    } else {
                        break;
                    }
                }

                service.addCar(new Car(id, model));
            }
            else if (choice == 2) {
                service.viewCars();
            }
            else if (choice == 3) {
                System.out.print("Enter Car ID: ");
                String id = scanner.nextLine();

                System.out.print("Customer Name: ");
                String name = scanner.nextLine();

                service.rentCar(id, name);
            }
            else if (choice == 4) {
                System.out.print("Enter Car ID: ");
                String id = scanner.nextLine();
                service.returnCar(id);
            }
            else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }

        }
    }
}
