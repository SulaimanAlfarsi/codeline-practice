package team.fromsulaiman.inventoryCli.service;


import team.fromsulaiman.inventoryCli.exception.ProductNotFoundException;
import team.fromsulaiman.inventoryCli.model.Product;
import team.fromsulaiman.inventoryCli.repository.ProductRepository;
import team.fromsulaiman.inventoryCli.util.FileManager;
import team.fromsulaiman.inventoryCli.util.IdGenerator;
import team.fromsulaiman.inventoryCli.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final String PRODUCT_FILE = "data/products.txt";

    private ProductRepository productRepository;
    private InputHelper input;

    public ProductService(ProductRepository productRepository, InputHelper input) {
        this.productRepository = productRepository;
        this.input = input;
    }

    public void showProductMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n========== Product Menu ==========");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Stock");
            System.out.println("0. Back");

            int choice = input.readInt("Choose: ");

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProduct();
                case 4 -> updateStock();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addProduct() {
        String id = IdGenerator.productId(productRepository.findAll().size() + 1);

        String name = input.readText("Product name: ");
        String category = input.readText("Category: ");
        double price = input.readDouble("Price: ");
        int quantity = input.readInt("Quantity: ");

        Product product = new Product(id, name, category, price, quantity);
        productRepository.add(product);

        System.out.println("Product added with ID: " + id);
    }

    public void viewProducts() {
        if (productRepository.findAll().isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product product : productRepository.findAll()) {
            System.out.println(product);
        }
    }

    private void searchProduct() {
        String id = input.readText("Product ID: ");

        try {
            Product product = getProductOrThrow(id);
            System.out.println(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateStock() {
        String id = input.readText("Product ID: ");

        try {
            Product product = getProductOrThrow(id);
            int newQuantity = input.readInt("New quantity: ");

            if (newQuantity < 0) {
                System.out.println("Quantity cannot be negative.");
                return;
            }

            product.setQuantity(newQuantity);
            System.out.println("Stock updated.");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getProductOrThrow(String id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + id);
        }

        return product;
    }

    public void saveProducts() {
        List<String> lines = new ArrayList<>();

        for (Product product : productRepository.findAll()) {
            lines.add(product.toFileLine());
        }

        FileManager.writeLines(PRODUCT_FILE, lines);
    }

    public void loadProducts() {
        List<String> lines = FileManager.readLines(PRODUCT_FILE);
        List<Product> products = new ArrayList<>();

        for (String line : lines) {
            if (!line.isBlank()) {
                products.add(Product.fromFileLine(line));
            }
        }

        productRepository.setProducts(products);
    }
}