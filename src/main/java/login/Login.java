package login;

import dao.UserDao;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UserDao userDao = new UserDao();
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
            if (userDao.isUser(login,pass)){
                session.setAttribute("login", userDao.getCurrentUser(login,pass).get(0).getLogin());
                session.setAttribute("pass", userDao.getCurrentUser(login,pass).get(0).getPass());
                session.setAttribute("name", userDao.getCurrentUser(login,pass).get(0).getName());
                session.setAttribute("surname", userDao.getCurrentUser(login,pass).get(0).getSurname());
                session.setAttribute("address",userDao.getCurrentUser(login,pass).get(0).getAddress());
                session.setAttribute("email",userDao.getCurrentUser(login,pass).get(0).getEmail());
                session.setAttribute("phone",userDao.getCurrentUser(login,pass).get(0).getPhone());
        }
        if (userDao.isUser(login,pass)){
            response.sendRedirect("/mainWindow");
        } else {
            response.sendRedirect("/incorrect");
        }
    }
}
