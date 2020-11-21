package Order;

import java.util.Map;

public class Order {
    private int idOrder;
    private String user;
    private Map map;

    public Order(int idOrder, String user, Map map) {
        this.idOrder = idOrder;
        this.user = user;
        this.map = map;
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
                '}';
    }
}
