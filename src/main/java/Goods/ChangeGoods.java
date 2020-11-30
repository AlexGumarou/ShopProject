package Goods;

import db.ConnectionDB;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeGoods")
public class ChangeGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (int i = 0; i< ConnectionDB.getInstance().getAllGoods().size(); i++) {
            String name = ConnectionDB.getInstance().getAllGoods().get(i).getName();
            if (req.getParameter("button").equals("Delete " + i)) {
                ConnectionDB.getInstance().deleteGoods(name);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
