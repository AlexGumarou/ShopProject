package Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//этот класс, если пользователь ничего не выбрал на главной странице, но нажал кнопку "Add goods"
@WebServlet("/emptyOrder")
public class EmptyOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Shop/emptyOrder.jsp").forward(req,resp);
    }
}
