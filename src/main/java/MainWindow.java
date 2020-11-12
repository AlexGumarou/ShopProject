import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainWindow")
public class MainWindow extends HttpServlet {
        protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
            response.setContentType("text/html");
            getServletContext().getRequestDispatcher("/mainWindow.jsp").forward(request, response);
        }

        protected void doPost (HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException{
            doGet(request,response);
        }
}
