import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.print(ServletsBasic.registrationPage);
            ListOfThePersons.map.put(request.getParameter("login"),request.getParameter("pass"));
            ListOfThePersons.addUsers(request.getParameter("login"),request.getParameter("pass"),
                    request.getParameter("name"), request.getParameter("surname"),
                    2020);
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
