package team.fromsulaiman.inventoryCli.service;


import team.fromsulaiman.inventoryCli.model.Order;
import team.fromsulaiman.inventoryCli.model.OrderItem;
import team.fromsulaiman.inventoryCli.model.Product;
import team.fromsulaiman.inventoryCli.repository.OrderRepository;
import team.fromsulaiman.inventoryCli.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class ReportService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public ReportService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void showReportsMenu() {
        System.out.println("\n========== Reports ==========");
        System.out.println("Total Orders: " + orderRepository.findAll().size());
        System.out.printf("Total Revenue: %.2f OMR%n", calculateTotalRevenue());
        System.out.println("Best Selling Product: " + findBestSellingProduct());
        printLowStockProducts();
    }

    private double calculateTotalRevenue() {
        double total = 0;

        for (Order order : orderRepository.findAll()) {
            total += order.getTotalAmount();
        }

        return total;
    }

    private String findBestSellingProduct() {
        Map<String, Integer> salesCount = new HashMap<>();

        for (Order order : orderRepository.findAll()) {
            for (OrderItem item : order.getItems()) {
                String productName = item.getProduct().getName();
                int oldQuantity = salesCount.getOrDefault(productName, 0);

                salesCount.put(productName, oldQuantity + item.getQuantity());
            }
        }

        String bestProduct = "No sales yet";
        int bestCount = 0;

        for (String productName : salesCount.keySet()) {
            if (salesCount.get(productName) > bestCount) {
                bestProduct = productName;
                bestCount = salesCount.get(productName);
            }
        }

        return bestProduct;
    }

    private void printLowStockProducts() {
        System.out.println("Low Stock Products:");

        boolean found = false;

        for (Product product : productRepository.findAll()) {
            if (product.getQuantity() <= 5) {
                System.out.println("- " + product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("- No low stock products");
        }
    }
}