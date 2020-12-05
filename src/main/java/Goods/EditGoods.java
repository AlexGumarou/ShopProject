package Goods;

import dao.GoodsDao;
import db.ConnectionDB;
import entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editGoods")
public class EditGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> list = goodsDao.getAllGoods();
        for (int i = 0; i< list.size(); i++) {
            if (req.getParameter("button").equals("Edit " + i)){
                req.setAttribute("id",list.get(i).getId());
                req.setAttribute("name",list.get(i).getName());
                req.setAttribute("description",list.get(i).getDescription());
                req.setAttribute("quantity",list.get(i).getQuantity());
                req.setAttribute("price",list.get(i).getPrice());
                getServletContext().getRequestDispatcher("/Shop/editGoods.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> list = goodsDao.getAllGoods();
        for (int i = 0; i< list.size(); i++) {
            int id = Integer.parseInt(req.getParameter("id"));
            int price = Integer.parseInt(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            if (list.get(i).getId() == id) {
                goodsDao.editGoods(id, name, description, quantity, price);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
