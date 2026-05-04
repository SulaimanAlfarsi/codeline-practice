package team.fromsulaiman.inventoryCli.service;


import team.fromsulaiman.inventoryCli.exception.InsufficientStockException;
import team.fromsulaiman.inventoryCli.model.Customer;
import team.fromsulaiman.inventoryCli.model.Invoice;
import team.fromsulaiman.inventoryCli.model.Order;
import team.fromsulaiman.inventoryCli.model.OrderItem;
import team.fromsulaiman.inventoryCli.model.Product;
import team.fromsulaiman.inventoryCli.repository.CustomerRepository;
import team.fromsulaiman.inventoryCli.repository.OrderRepository;
import team.fromsulaiman.inventoryCli.repository.ProductRepository;
import team.fromsulaiman.inventoryCli.util.FileManager;
import team.fromsulaiman.inventoryCli.util.IdGenerator;
import team.fromsulaiman.inventoryCli.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final String ORDER_FILE = "data/orders.txt";

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private InputHelper input;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        CustomerRepository customerRepository,
                        InputHelper input) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.input = input;
    }

    public void showOrderMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n========== Order Menu ==========");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. View Order Details");
            System.out.println("0. Back");

            int choice = input.readInt("Choose: ");

            switch (choice) {
                case 1 -> createOrder();
                case 2 -> viewOrders();
                case 3 -> viewOrderDetails();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void createOrder() {
        if (customerRepository.findAll().isEmpty()) {
            System.out.println("Add a customer first.");
            return;
        }

        if (productRepository.findAll().isEmpty()) {
            System.out.println("Add products first.");
            return;
        }

        String customerId = input.readText("Customer ID: ");
        Customer customer = customerRepository.findById(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        String orderId = IdGenerator.orderId(orderRepository.findAll().size() + 1);
        Order order = new Order(orderId, customer);

        boolean addingItems = true;

        while (addingItems) {
            String productId = input.readText("Product ID: ");
            Product product = productRepository.findById(productId);

            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            int quantity = input.readInt("Quantity: ");

            try {
                validateStock(product, quantity);

                OrderItem item = new OrderItem(product, quantity);
                order.addItem(item);

                product.reduceStock(quantity);

                System.out.println("Item added.");
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }

            String answer = input.readText("Add another item? yes/no: ");

            if (!answer.equalsIgnoreCase("yes")) {
                addingItems = false;
            }
        }

        if (order.getItems().isEmpty()) {
            System.out.println("Order cancelled. No items added.");
            return;
        }

        orderRepository.add(order);

        System.out.println("Order created successfully.");
        new Invoice(order).print();
    }

    private void validateStock(Product product, int quantity) {
        if (quantity <= 0) {
            throw new InsufficientStockException("Quantity must be more than zero.");
        }

        if (product.getQuantity() < quantity) {
            throw new InsufficientStockException("Not enough stock. Available: " + product.getQuantity());
        }
    }

    private void viewOrders() {
        if (orderRepository.findAll().isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orderRepository.findAll()) {
            System.out.println(order);
        }
    }

    private void viewOrderDetails() {
        String id = input.readText("Order ID: ");
        Order order = orderRepository.findById(id);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        new Invoice(order).print();
    }

    public void saveOrders() {
        List<String> lines = new ArrayList<>();

        for (Order order : orderRepository.findAll()) {
            StringBuilder line = new StringBuilder();

            line.append(order.getId()).append("|");
            line.append(order.getCustomer().getId()).append("|");

            for (OrderItem item : order.getItems()) {
                line.append(item.getProduct().getId())
                        .append(":")
                        .append(item.getQuantity())
                        .append(";");
            }

            lines.add(line.toString());
        }

        FileManager.writeLines(ORDER_FILE, lines);
    }

    public void loadOrders() {
        List<String> lines = FileManager.readLines(ORDER_FILE);

        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }

            String[] mainParts = line.split("\\|");

            if (mainParts.length < 3) {
                continue;
            }

            Customer customer = customerRepository.findById(mainParts[1]);

            if (customer == null) {
                continue;
            }

            Order order = new Order(mainParts[0], customer);

            String[] items = mainParts[2].split(";");

            for (String itemText : items) {
                if (itemText.isBlank()) {
                    continue;
                }

                String[] itemParts = itemText.split(":");

                Product product = productRepository.findById(itemParts[0]);
                int quantity = Integer.parseInt(itemParts[1]);

                if (product != null) {
                    order.addItem(new OrderItem(product, quantity));
                }
            }

            orderRepository.add(order);
        }
    }
}