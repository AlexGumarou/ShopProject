import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationIncorrect")
public class RegistrationIncorrect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            getServletContext().getRequestDispatcher("/RegistrationPageIncorrect.jsp").forward(request,response);
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String regExpLogin = "[a-zA-Z0-9]+";
        String regExpPass = "([a-zA-Z0-9]*[A-Z]+[0-9]+[a-zA-Z0-9]*||[a-zA-Z0-9]*[0-9]+[A-Z]+[a-zA-Z0-9]*)";
        try {
            if (!ListOfThePersons.map.containsKey(request.getParameter("login")) &&
                    request.getParameter("login").matches(regExpLogin) &&
                    request.getParameter("pass").matches(regExpPass)) {
                ListOfThePersons.addUsersMap(request.getParameter("login"), request.getParameter("pass"));
                ListOfThePersons.addUsersList(request.getParameter("login"), request.getParameter("pass"),
                        request.getParameter("name"), request.getParameter("surname"));
                response.sendRedirect("/");
            } else response.sendRedirect("/registrationIncorrect");
        } finally {
            writer.close();
        }
    }
}
