package Order;

import dao.UserDao;
import entity.PersonalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deliveryFinal")
public class DeliveryFinal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        for (PersonalData data : userDao.getAllUsers()) {
            data.setAddress(address);
            data.setEmail(email);
            data.setPhone(phone);
        }
        getServletContext().getRequestDispatcher(("/Shop/deliveryFinal.jsp")).forward(req,resp);
    }
}
