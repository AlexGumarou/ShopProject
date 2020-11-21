package Order;

import Goods.GoodsStorage;
import login.ListOfThePersons;

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
        ListOfThePersons.getMapOrder().clear();
        //здесь я удаляю все значния, сохраненные в MapOrder для того, чтобы они не попали в следующий заказ
        int size = GoodsStorage.getListOfGoods().size();
        for (int i= 0; i < size; i++) {
            int quantity = GoodsStorage.getListOfGoods().get(i).getQuantity();
            try {
                if (quantity != 0){
                    if (!req.getParameter("goods " + i).trim().equals("") && quantity > 0) {
                        int a = Integer.parseInt(req.getParameter("goods " + i));
                        if (a > 0) {
                            GoodsStorage.getListOfGoods().get(i).setIdPreOrder(Math.min(a, quantity));
                        }
                    } else {
                        GoodsStorage.getListOfGoods().get(i).setIdPreOrder(0);
                    }
            }
            } catch (NumberFormatException | IllegalStateException e) {
                getServletContext().getRequestDispatcher("/Shop/incorrectValue.jsp").forward(req, resp);
            }
        }
        getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req, resp);
    }
}
