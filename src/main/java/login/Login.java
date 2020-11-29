package login;

import db.ConnectionDB;

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
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
            if (ConnectionDB.getInstance().isUser(login,pass)){
                session.setAttribute("login", ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getLogin());
                session.setAttribute("pass", ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getPass());
                session.setAttribute("name", ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getName());
                session.setAttribute("surname", ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getSurname());
                session.setAttribute("address",ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getAddress());
                session.setAttribute("email",ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getEmail());
                session.setAttribute("phone",ConnectionDB.getInstance().isCurrentUser(login,pass).get(0).getPhone());
        }
        if (ConnectionDB.getInstance().isUser(login,pass)){
            response.sendRedirect("/mainWindow");
        } else {
            response.sendRedirect("/incorrect");
        }
    }
}
