package team.fromsulaiman.inventoryCli.repository;


import team.fromsulaiman.inventoryCli.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }

        return null;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}