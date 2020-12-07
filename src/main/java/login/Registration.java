package login;

import dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/User/registrationPage.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UserDao userDao = new UserDao();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        if (userDao.isUser(login, pass) || login.equals("".trim())
                || pass.equals("".trim()) || name.equals("".trim())){
            response.sendRedirect("/registrationIncorrect");
        } else {
            userDao.addUser(login, pass, name, surname);
            response.sendRedirect("/");
        }
    }
}
