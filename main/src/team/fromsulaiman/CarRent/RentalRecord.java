package team.fromsulaiman.CarRent;

public class RentalRecord {
    private String carId;
    private String customerName;

    public RentalRecord(String carId, String customerName) {
        this.carId = carId;
        this.customerName = customerName;
    }

    public void display() {
        System.out.println(carId + " rented by " + customerName);
    }


}
