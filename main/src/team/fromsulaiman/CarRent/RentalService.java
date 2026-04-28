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

}
