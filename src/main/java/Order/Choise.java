package Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//здесь происходит перенаправление в зависимости от выбора доставки
@WebServlet("/choise")
public class Choise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("wayOf").equals("pickUp")){
            resp.sendRedirect("/selfDelivery");
        } else {
            resp.sendRedirect("/delivery");
        }
    }
}
