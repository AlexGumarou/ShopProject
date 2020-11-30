package Order;

import db.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Сюда попадают товары, которы выбрал пользователь
При нажатии кнопки "buy" происходит сохранение заказа пользователя в "хранилище заказов",
которые можно потом посмотреть в личном кабинете
*/
@WebServlet("/basket")
public class Basket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int size = ConnectionDB.getInstance().getAllGoods().size();
        for (int i = 0; i < size; i++) {
            int quantity = ConnectionDB.getInstance().getAllGoods().get(i).getQuantity();
            try {
                if (quantity != 0){
                    if (!req.getParameter("goods " + i).trim().equals("") && quantity > 0) {
                        int a = Integer.parseInt(req.getParameter("goods " + i));
                        if (a > quantity){
                            req.getSession().setAttribute("msg"+i,"We have only " +
                                    ConnectionDB.getInstance().getAllGoods().get(i).getQuantity() + " of " +
                                    ConnectionDB.getInstance().getAllGoods().get(i).getName() + ". " +
                                    "We have to add max we have. <br>"
                            );
                            a = quantity;
                        }
                        if (a > 0) {
                            String name = ConnectionDB.getInstance().getAllGoods().get(i).getName();
                            int price = ConnectionDB.getInstance().getAllGoods().get(i).getPrice();
                            int sum = a * price;
                            ConnectionDB.getInstance().addOneOrder(name, price, a, sum);
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
