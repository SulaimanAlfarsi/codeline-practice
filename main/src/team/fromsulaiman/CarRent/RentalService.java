package team.fromsulaiman.CarRent;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


public class RentalService {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<RentalRecord> history = new ArrayList<>();

    public void addCar(Car car) {
        if (car == null) {
            System.out.println("Invalid car.");
            return;
        }

        if (findCar(car.getId()) != null) {
            System.out.println("Car ID already exists.");
            return;
        }

        cars.add(car);
        System.out.println("Car added successfully.");
    }

    public void viewCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (Car car : cars) {
            car.displayInfo();
        }
    }

    public Car findCar(String id) {
        for (Car car : cars) {
            if (car.getId().equalsIgnoreCase(id)) {
                return car;
            }
        }
        return null;
    }

    public void rentCar(String id, String customerName) {
        Car car = findCar(id);
        history.add(new RentalRecord(id, customerName));

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.isRented()) {
            System.out.println("Car already rented.");
            return;
        }

        car.rent(customerName);
        System.out.println("Car rented to " + customerName);
    }

    public void returnCar(String id) {
        Car car = findCar(id);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (!car.isRented()) {
            System.out.println("Car is not rented.");
            return;
        }

        car.returnCar();
        System.out.println("Car returned successfully.");
    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No rental history.");
            return;
        }

        for (RentalRecord r : history) {
            r.display();
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("data.txt")) {

            for (Car car : cars) {
                writer.write(car.getId() + "," + car.getModel() + "," + car.isRented() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }


}
