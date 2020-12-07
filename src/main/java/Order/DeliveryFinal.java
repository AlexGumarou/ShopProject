package Order;

import dao.UserDao;
import entity.Goods;
import entity.PersonalData;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deliveryFinal")
public class DeliveryFinal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        HttpSession session = req.getSession();
        List<PersonalData> list = userDao.getAllUsers();
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String name = (String) session.getAttribute("name");
        for (PersonalData personalData : list) {
            if (personalData.getName().equals(name)) {
                int id = personalData.getId();
                userDao.setAdditionalFields(id,address,email,phone);
            }
        }
        getServletContext().getRequestDispatcher(("/Shop/deliveryFinal.jsp")).forward(req,resp);
    }
}
