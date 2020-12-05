package login;

import dao.UserDao;
import db.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changeUsers")
public class ChangeUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        UserDao userDao = new UserDao();
        if (req.getParameter("button").equals("Delete " + 0)){
            writer.print("Unable to delete ADMIN");
        }
        for (int i = 1; i<userDao.getAllUsers().size(); i++) {
            if (req.getParameter("button").equals("Delete " + i)) {
                int id = userDao.getAllUsers().get(i).getId();
                userDao.deleteUser(id);
                resp.sendRedirect("/userStore");
            }
        }
    }
}
