package team.fromsulaiman.inventoryCli.model;

public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(String id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceStock(int amount) {
        this.quantity -= amount;
    }

    public String toFileLine() {
        return id + "," + name + "," + category + "," + price + "," + quantity;
    }

    public static Product fromFileLine(String line) {
        String[] parts = line.split(",");

        return new Product(
                parts[0],
                parts[1],
                parts[2],
                Double.parseDouble(parts[3]),
                Integer.parseInt(parts[4])
        );
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + price + " OMR | Qty: " + quantity;
    }
}