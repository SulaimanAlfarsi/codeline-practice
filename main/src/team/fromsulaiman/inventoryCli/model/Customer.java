package team.fromsulaiman.inventoryCli.model;


public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;

    public Customer(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toFileLine() {
        return id + "," + name + "," + phone + "," + email;
    }

    public static Customer fromFileLine(String line) {
        String[] parts = line.split(",");

        return new Customer(parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone + " | " + email;
    }
}