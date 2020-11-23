package Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editGoods")
public class EditGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i< GoodsStorage.getListOfGoods().size(); i++) {
            if (req.getParameter("button").equals("Edit " + i)){
                req.setAttribute("id",GoodsStorage.getListOfGoods().get(i).getId());
                req.setAttribute("name",GoodsStorage.getListOfGoods().get(i).getName());
                req.setAttribute("description",GoodsStorage.getListOfGoods().get(i).getDescription());
                req.setAttribute("quantity",GoodsStorage.getListOfGoods().get(i).getQuantity());
                req.setAttribute("price",GoodsStorage.getListOfGoods().get(i).getPrice());
                getServletContext().getRequestDispatcher("/Shop/editGoods.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i< GoodsStorage.getListOfGoods().size(); i++) {
            int id = Integer.parseInt(req.getParameter("id"));
            int price = Integer.parseInt(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            if (GoodsStorage.getListOfGoods().get(i).getId() == id) {
                GoodsStorage.editNewGoods(i+1, name, description, quantity, price, 0);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
