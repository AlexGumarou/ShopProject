package Goods;

import login.ListOfThePersons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeGoods")
public class ChangeGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (int i = 0; i< GoodsStorage.getListOfGoods().size(); i++) {
            if (req.getParameter("button").equals("Delete " + i)) {
                GoodsStorage.getListOfGoods().remove(i);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
