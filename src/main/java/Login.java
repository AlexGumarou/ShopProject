import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

    @Override
    public void init (){
        ListOfThePersons.addAdmin();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();

        for (int i = 0; i < ListOfThePersons.list.size(); i++){
            if (ListOfThePersons.list.get(i).getLogin().equals(request.getParameter("login"))
            && ListOfThePersons.list.get(i).getPass().equals(request.getParameter("pass"))){
                session.setAttribute("login", ListOfThePersons.list.get(i).getLogin());
                session.setAttribute("pass", ListOfThePersons.list.get(i).getPass());
                session.setAttribute("name", ListOfThePersons.list.get(i).getName());
                session.setAttribute("surname", ListOfThePersons.list.get(i).getSurname());
            }
        }
        if (ListOfThePersons.map.containsKey(request.getParameter("login"))
                && ListOfThePersons.map.containsValue(request.getParameter("pass"))){
            response.sendRedirect("/mainWindow");
        } else {
            response.sendRedirect("/incorrect");
        }
    }
}
