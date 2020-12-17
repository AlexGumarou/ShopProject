package Order;

import dao.GoodsDao;
import dao.OrderDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/basket")
public class Basket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        req.setAttribute("listOneOrder", orderDao.getOneOrder());
        getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        OrderDao orderDao = new OrderDao();
        req.setAttribute("listOneOrder", orderDao.getOneOrder());
        int size = goodsDao.getAllGoods().size();
        for (int i = 0; i < size; i++) {
            int quantity = goodsDao.getAllGoods().get(i).getQuantity();
            try {
                if (quantity != 0){
                    if (!req.getParameter("goods " + i).trim().equals("") && quantity > 0) {
                        int a = Integer.parseInt(req.getParameter("goods " + i));
                        if (a > quantity){
                            req.getSession().setAttribute("msg"+i,"We have only " +
                                    goodsDao.getAllGoods().get(i).getQuantity() + " of " +
                                    goodsDao.getAllGoods().get(i).getName() + ". " +
                                    "We have to add max we have. <br>"
                            );
                            a = quantity;
                        }
                        if (a > 0) {
                            String name = goodsDao.getAllGoods().get(i).getName();
                            int price = goodsDao.getAllGoods().get(i).getPrice();
                            int sum = a * price;
                            orderDao.addOneOrder(name, price, a, sum);
                        }
                    }
            }
            } catch (NumberFormatException | IllegalStateException e) {
                getServletContext().getRequestDispatcher("/Shop/incorrectValue.jsp").forward(req, resp);
            }
        }
        getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req, resp);
    }
}
