package Order;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private final int idOrder;
    private final String name;
    private final int price;
    private final int quantity;
    private final int sum;

    public Order(int idOrder, String name, int price, int quantity, int sum) {
        this.idOrder = idOrder;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }
}
