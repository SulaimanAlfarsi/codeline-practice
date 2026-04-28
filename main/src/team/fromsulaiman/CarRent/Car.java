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
        this.customerName = null;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public boolean isRented() { return isRented; }

    public void rent(String customerName) {
        this.isRented = true;
        this.customerName = customerName;
    }

    public void returnCar() {
        this.isRented = false;
        this.customerName = null;
    }

    public void displayInfo() {
        System.out.println(id + " | " + model + " | " + (isRented ? "Rented" : "Available"));
    }

}
