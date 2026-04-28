package team.fromsulaiman.CarRent;
import java.util.ArrayList;


public class RentalService {

    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        if (car == null) {
            System.out.println("Invalid car.");
            return;
        }
        cars.add(car);
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

    public void rentCar(String id) {
        Car car = findCar(id);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.isRented()) {
            System.out.println("Car already rented.");
            return;
        }

        car.rent();
        System.out.println("Car rented successfully.");
    }


}
