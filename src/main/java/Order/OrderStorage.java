package Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStorage {

    static Map<Integer,String> mapOrder = new HashMap<>();
    static List<Order> orderList = new ArrayList<>();

    public static void addOrdersMap(Integer number, String order){
        mapOrder.put(number, order);
    }
    public static Map<Integer, String> getMapOrder() {
        return mapOrder;
    }

    public static void addOrdersList(Integer number, String user, Map map, LocalDateTime time){
        orderList.add(new Order(number,user,map, time));
    }
    public static List<Order> getOrderList() {
        return orderList;
    }
}
