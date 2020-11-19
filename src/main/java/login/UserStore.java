package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userStore")
public class UserStore extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", ListOfThePersons.getList());
        request.setAttribute("max",ListOfThePersons.getList().size()-1);
        getServletContext().getRequestDispatcher("/User/userStore.jsp").forward(request, response);
    }
}
