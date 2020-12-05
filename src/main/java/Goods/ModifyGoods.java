package Goods;

import dao.GoodsDao;
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
        GoodsDao goodsDao = new GoodsDao();
        req.setAttribute("goods", goodsDao.getAllGoods());
        req.setAttribute("max",goodsDao.getAllGoods().size() - 1);
        getServletContext().getRequestDispatcher("/Shop/modifyGoods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        req.setAttribute("goods", goodsDao.getAllGoods());
        req.setAttribute("max",goodsDao.getAllGoods().size() - 1);
        getServletContext().getRequestDispatcher("/Shop/modifyGoods.jsp").forward(req, resp);
    }
}
