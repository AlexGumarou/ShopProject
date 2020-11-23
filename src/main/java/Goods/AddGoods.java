package Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.IllegalFormatException;

@WebServlet("/addGoods")
public class AddGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Shop/addGoods.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int price = Integer.parseInt(req.getParameter("price"));
            if (quantity > 0 && price > 0 && !req.getParameter("name").equals("".trim())
            && !req.getParameter("description").equals("".trim())) {
                GoodsStorage.addNewGoods(GoodsStorage.getListOfGoods().size() + 1, req.getParameter("name"),
                        req.getParameter("description"), quantity, price, 0);
                resp.sendRedirect("/modifyGoods");
            } else {
                resp.sendRedirect("/Shop/incorrectAdd.jsp");
            }
        }catch (NumberFormatException | IllegalFormatException e){
            resp.sendRedirect("/Shop/incorrectAdd.jsp");
        }
    }
}
