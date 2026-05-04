package team.fromsulaiman.inventoryCli.util;


public class IdGenerator {
    public static String productId(int number) {
        return String.format("P-%03d", number);
    }

    public static String customerId(int number) {
        return String.format("C-%03d", number);
    }

    public static String orderId(int number) {
        return String.format("O-%03d", number);
    }
}