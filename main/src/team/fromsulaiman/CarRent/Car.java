package team.fromsulaiman.CarRent;

public class Car {
    private String id;
    private String model;
    private boolean isRented;

    public Car(String id, String model) {
        this.id = id;
        this.model = model;
        this.isRented = false;
    }

}
