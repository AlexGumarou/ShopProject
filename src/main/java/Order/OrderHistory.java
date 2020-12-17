package Order;

import dao.OrderDao;
import entity.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderHistory")
public class OrderHistory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        req.setAttribute("mapOrder", orderDao.getAllOrders());
        getServletContext().getRequestDispatcher("/Shop/orderHistory.jsp").forward(req,resp);
    }

}
