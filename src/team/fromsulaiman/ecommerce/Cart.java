package fromsulaiman.ecommerce;
import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (CartItem item : items) {
            System.out.println(
                    item.getProduct().getName() + " x" + item.getQuantity()
            );
        }
    }

}
