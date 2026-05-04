package team.fromsulaiman.inventoryCli.model;


public class Invoice {
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public void print() {
        System.out.println("\n================ INVOICE ================");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-8s %-10s %-10s%n", "Product", "Qty", "Price", "Subtotal");

        for (OrderItem item : order.getItems()) {
            System.out.printf(
                    "%-15s %-8d %-10.2f %-10.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getProduct().getPrice(),
                    item.getSubtotal()
            );
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Total: %.2f OMR%n", order.getTotalAmount());
        System.out.println("=========================================");
    }
}