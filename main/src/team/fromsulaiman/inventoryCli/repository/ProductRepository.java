package team.fromsulaiman.inventoryCli.repository;


import team.fromsulaiman.inventoryCli.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        return null;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}