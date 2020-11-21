package Order;

import Goods.Goods;
import Goods.GoodsStorage;
import login.ListOfThePersons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                order = "Your order was: " + name + " - pieces each one " + price +
                        "$ and quantity of it was: " + idOrder;
                ListOfThePersons.addOrdersMap(ListOfThePersons.getMapOrder().size() + 1, order);
            }
        }
        ListOfThePersons.addOrdersList(ListOfThePersons.getOrderList().size()+1,
                user, ListOfThePersons.getMapOrder());
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
