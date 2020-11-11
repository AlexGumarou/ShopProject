import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class PersonalDataBase extends HttpServlet {
ListOfThePersons listOfThePersons = new ListOfThePersons();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        listOfThePersons.addAdmin();
        try {
            writer.println("<h1>You account data is:</h1>\n" + listOfThePersons.list.size());
        } finally {
            writer.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
