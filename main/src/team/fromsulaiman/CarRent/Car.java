package team.fromsulaiman.CarRent;

public class Car {
    private String id;
    private String model;
    private boolean isRented;
    private String customerName;

    public Car(String id, String model) {
        this.id = id;
        this.model = model;
        this.isRented = false;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public boolean isRented() { return isRented; }

    public void rent() {
        isRented = true;
    }

    public void returnCar() {
        isRented = false;
    }

    public void displayInfo() {
        System.out.println(id + " | " + model + " | " + (isRented ? "Rented" : "Available"));
    }

}
