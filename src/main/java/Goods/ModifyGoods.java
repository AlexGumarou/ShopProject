package Goods;

import db.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyGoods")
public class ModifyGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("goods", ConnectionDB.getInstance().getAllGoods());
        req.setAttribute("max",ConnectionDB.getInstance().getAllGoods().size() - 1);
        getServletContext().getRequestDispatcher("/Shop/modifyGoods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("goods", ConnectionDB.getInstance().getAllGoods());
        req.setAttribute("max",ConnectionDB.getInstance().getAllGoods().size() - 1);
        getServletContext().getRequestDispatcher("/Shop/modifyGoods.jsp").forward(req, resp);
    }
}
