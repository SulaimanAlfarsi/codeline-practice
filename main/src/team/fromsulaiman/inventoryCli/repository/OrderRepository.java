package team.fromsulaiman.inventoryCli.repository;


import team.fromsulaiman.inventoryCli.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return orders;
    }

    public Order findById(String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order;
            }
        }

        return null;
    }
}