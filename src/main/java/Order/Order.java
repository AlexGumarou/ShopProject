package Order;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private int idOrder;
    private String user;
    private Map map;
    private LocalDateTime time;

    public Order(int idOrder, String user, Map map, LocalDateTime time) {
        this.idOrder = idOrder;
        this.user = user;
        this.map = map;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Object getUser() {
        return user;
    }

    public Map getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", user='" + user + '\'' +
                ", map=" + map +
                ", time=" + time +
                '}';
    }
}
