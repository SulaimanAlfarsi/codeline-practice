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
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }

        }
    }
}
