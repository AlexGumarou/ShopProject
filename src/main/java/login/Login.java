package login;

import java.io.IOException;
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
        for (PersonalData data : ListOfThePersons.getList()){
            if (data.getLogin().equals(request.getParameter("login"))
            && data.getPass().equals(request.getParameter("pass"))){
                session.setAttribute("login", data.getLogin());
                session.setAttribute("pass", data.getPass());
                session.setAttribute("name", data.getName());
                session.setAttribute("surname", data.getSurname());
                session.setAttribute("address",data.getAddress());
                session.setAttribute("email",data.getEmail());
                session.setAttribute("phone",data.getPhone());
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
