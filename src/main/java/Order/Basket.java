package Order;

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
@WebServlet("/Order/Basket")
public class Basket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/Shop/basket.jsp").forward(req,resp);
    }
}
