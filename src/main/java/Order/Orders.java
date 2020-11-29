package Order;

import java.time.LocalDateTime;

public class Orders {
    private final int id;
    private final String users;
    private final String orders;
    private final LocalDateTime time;

    public Orders(int id, String users, String orders, LocalDateTime time) {
        this.id = id;
        this.users = users;
        this.orders = orders;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getUsers() {
        return users;
    }

    public String getOrders() {
        return orders;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", users='" + users + '\'' +
                ", orders='" + orders + '\'' +
                ", time=" + time +
                '}';
    }
}
