package Order;

import Goods.Goods;
import Goods.GoodsStorage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

//позже сделать большинство, что тут написано в отдельном классе
@WebServlet("/choise")
public class Choise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //ниже я достаю все не 0 значения поля IdPreOrder и сохраняю как String и добавляю заказ в историю
        String user =  req.getSession().getAttribute("login").toString();
        String order;
        for (Goods goods : GoodsStorage.getListOfGoods()){
            if (goods.getIdPreOrder() > 0 ){
                String name = goods.getName();
                int idOrder = goods.getIdPreOrder();
                int price = goods.getPrice();
                order = "Your order was: " + name + " - each one " + price +
                        "$ and quantity of it was: " + idOrder + "<br>";
                int size = OrderStorage.getMapOrder().size();
                OrderStorage.addOrdersMap( size + 1, order);
            }
        }
        int size = OrderStorage.getOrderList().size();
        Map map = OrderStorage.getMapOrder();
        OrderStorage.addOrdersList(size+1, user, map.toString().
                replace("{","").replace("}","")
                .replace(",",""), LocalDateTime.now());
        // ниже я уменьшаю значения товаров, которые куплены
        for (Goods goods : GoodsStorage.getListOfGoods()){
            if (goods.getIdPreOrder() > 0 ){
                int quantity = goods.getQuantity();
                int idPreOrder = goods.getIdPreOrder();
                int result = quantity - idPreOrder;
                goods.setQuantity(result);
            }
        }
        // ниже я делаю 0 все значения поля IdPreOrder
        for (Goods goods : GoodsStorage.getListOfGoods()){
            if (goods.getIdPreOrder() > 0 ){
                goods.setIdPreOrder(0);
            }
        }
        //ниже я перенаправляю пользователя в зависисмости от его выбора
        if (req.getParameter("wayOf") != null) {
            if (req.getParameter("wayOf").equals("pickUp")) {
                resp.sendRedirect("/selfDelivery");
            } else if (req.getParameter("wayOf").equals("delivery")) {
                resp.sendRedirect("/delivery");
            }
        }
    }
}
