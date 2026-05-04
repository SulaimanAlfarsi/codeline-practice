package team.fromsulaiman.inventoryCli;


import team.fromsulaiman.inventoryCli.repository.CustomerRepository;
import team.fromsulaiman.inventoryCli.repository.OrderRepository;
import team.fromsulaiman.inventoryCli.repository.ProductRepository;
import team.fromsulaiman.inventoryCli.service.CustomerService;
import team.fromsulaiman.inventoryCli.service.OrderService;
import team.fromsulaiman.inventoryCli.service.ProductService;
import team.fromsulaiman.inventoryCli.service.ReportService;
import team.fromsulaiman.inventoryCli.util.InputHelper;

public class Main {
    private static final InputHelper input = new InputHelper();

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        ProductService productService = new ProductService(productRepository, input);
        CustomerService customerService = new CustomerService(customerRepository, input);
        OrderService orderService = new OrderService(
                orderRepository,
                productRepository,
                customerRepository,
                input
        );
        ReportService reportService = new ReportService(orderRepository, productRepository);

        productService.loadProducts();
        customerService.loadCustomers();
        orderService.loadOrders();

        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = input.readInt("Choose: ");

            switch (choice) {
                case 1 -> productService.showProductMenu();
                case 2 -> customerService.showCustomerMenu();
                case 3 -> orderService.showOrderMenu();
                case 4 -> reportService.showReportsMenu();
                case 0 -> {
                    productService.saveProducts();
                    customerService.saveCustomers();
                    orderService.saveOrders();

                    System.out.println("Data saved. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n========== Inventory & Sales CLI ==========");
        System.out.println("1. Product Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Order Management");
        System.out.println("4. Reports");
        System.out.println("0. Exit");
    }
}