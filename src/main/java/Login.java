import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
ListOfThePersons listOfThePersons = new ListOfThePersons();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        listOfThePersons.addAdmin();

        try { if (listOfThePersons.map.containsKey(request.getParameter("login"))
        && listOfThePersons.map.containsValue(request.getParameter("pass"))){
            response.sendRedirect("/mainWindow");
        }else { writer.println(ServletsBasic.startPageIncorrectAnswer);
        }
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
