package team.fromsulaiman.inventoryCli.service;


import team.fromsulaiman.inventoryCli.exception.CustomerNotFoundException;
import team.fromsulaiman.inventoryCli.model.Customer;
import team.fromsulaiman.inventoryCli.repository.CustomerRepository;
import team.fromsulaiman.inventoryCli.util.FileManager;
import team.fromsulaiman.inventoryCli.util.IdGenerator;
import team.fromsulaiman.inventoryCli.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static final String CUSTOMER_FILE = "data/customers.txt";

    private CustomerRepository customerRepository;
    private InputHelper input;

    public CustomerService(CustomerRepository customerRepository, InputHelper input) {
        this.customerRepository = customerRepository;
        this.input = input;
    }

    public void showCustomerMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n========== Customer Menu ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("0. Back");

            int choice = input.readInt("Choose: ");

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> viewCustomers();
                case 3 -> searchCustomer();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addCustomer() {
        String id = IdGenerator.customerId(customerRepository.findAll().size() + 1);

        String name = input.readText("Customer name: ");
        String phone = input.readText("Phone: ");
        String email = input.readText("Email: ");

        Customer customer = new Customer(id, name, phone, email);
        customerRepository.add(customer);

        System.out.println("Customer added with ID: " + id);
    }

    private void viewCustomers() {
        if (customerRepository.findAll().isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
    }

    private void searchCustomer() {
        String id = input.readText("Customer ID: ");

        try {
            Customer customer = getCustomerOrThrow(id);
            System.out.println(customer);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Customer getCustomerOrThrow(String id) {
        Customer customer = customerRepository.findById(id);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found: " + id);
        }

        return customer;
    }

    public void saveCustomers() {
        List<String> lines = new ArrayList<>();

        for (Customer customer : customerRepository.findAll()) {
            lines.add(customer.toFileLine());
        }

        FileManager.writeLines(CUSTOMER_FILE, lines);
    }

    public void loadCustomers() {
        List<String> lines = FileManager.readLines(CUSTOMER_FILE);
        List<Customer> customers = new ArrayList<>();

        for (String line : lines) {
            if (!line.isBlank()) {
                customers.add(Customer.fromFileLine(line));
            }
        }

        customerRepository.setCustomers(customers);
    }
}