package Order;

import dao.GoodsDao;
import dao.OrderDao;
import entity.Goods;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//позже сделать большинство, что тут написано в отдельном классе
@WebServlet("/choise")
public class Choise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        OrderDao orderDao = new OrderDao();
        GoodsDao goodsDao = new GoodsDao();
        String user =  req.getSession().getAttribute("login").toString();
        orderDao.addOrders(user,orderDao.getOneOrder()
                .toString().replace("{","").replace("}","")
                .replace(",","").replace("[","").replace("]",""));
        // ниже я уменьшаю значения товаров, которые куплены
        List<Order> listOrder = orderDao.getOneOrder();
        List<Goods> listGoods = goodsDao.getAllGoods();
        for (Order order : listOrder) {
            int quantity = order.getQuantity();
            String name = order.getName();
            for (Goods goods : listGoods) {
                if (goods.getName().equals(name)){
                    int id = goods.getId();
                    int result = goods.getQuantity() - quantity;
                    goodsDao.changeGoods(id,result);
                }
            }
        }
        //ниже я перенаправляю пользователя в зависисмости от его выбора
        if (req.getParameter("wayOf") != null) {
            if (req.getParameter("wayOf").equals("pickUp")) {
                resp.sendRedirect("/selfDelivery");
            } else if (req.getParameter("wayOf").equals("delivery")) {
                resp.sendRedirect("/delivery");
            }
        } else {
            resp.sendRedirect("/basket");
        }
    }
}