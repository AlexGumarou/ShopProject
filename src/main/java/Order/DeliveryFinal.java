package Order;

import login.ListOfThePersons;
import login.PersonalData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/deliveryFinal")
public class DeliveryFinal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        for (PersonalData data : ListOfThePersons.getList()) {
            data.setAddress(address);
            data.setEmail(email);
            data.setPhone(phone);
        }
        getServletContext().getRequestDispatcher(("/Shop/deliveryFinal.jsp")).forward(req,resp);
    }
}
