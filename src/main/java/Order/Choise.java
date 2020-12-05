package Order;

import dao.OrderDao;
import db.ConnectionDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//позже сделать большинство, что тут написано в отдельном классе
@WebServlet("/choise")
public class Choise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderDao orderDao = new OrderDao();
        String user =  req.getSession().getAttribute("login").toString();
        String date = LocalDateTime.now().toString();
        orderDao.addOrders(user,orderDao.getOneOrder()
                .toString().replace("{","").replace("}","")
                .replace(",","").replace("[","").replace("]",""));
        // ниже я уменьшаю значения товаров, которые куплены

//        for (Goods goods : ConnectionDB.getInstance().getAllGoods()){
//            if (goods.getIdPreOrder() > 0 ){
//                int quantity = goods.getQuantity();
//                int idPreOrder = goods.getIdPreOrder();
//                int result = quantity - idPreOrder;
//                goods.setQuantity(result);
//            }
//        }
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