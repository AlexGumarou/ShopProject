import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        ListOfThePersons.addAdmin();

        try { if (ListOfThePersons.map.containsKey(request.getParameter("login"))
        && ListOfThePersons.map.containsValue(request.getParameter("pass"))){
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
