package Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//здесь передается информация о месте самовывоза товара (информационно)
@WebServlet("/selfDelivery")
public class SelfDelivery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Shop/selfDelivery.jsp").forward(req,resp);
    }
}
