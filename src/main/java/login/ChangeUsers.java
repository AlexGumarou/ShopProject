package login;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        if (req.getParameter("button").equals("Delete " + 0)){
            writer.print("Unable to delete ADMIN");
        }
        for (int i = 1; i<ListOfThePersons.list.size(); i++) {
            if (req.getParameter("button").equals("Delete " + i)) {
                String login = ListOfThePersons.list.get(i).getLogin();
                String pass = ListOfThePersons.list.get(i).getPass();
                ListOfThePersons.removeUsersMap(login, pass);
                ListOfThePersons.list.remove(i);
                resp.sendRedirect("/userStore");
            }
        }
    }
}
