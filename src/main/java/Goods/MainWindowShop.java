package Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//главная страница магазина с отображением всех товаров и возможностью их добавления в корзину
@WebServlet("/mainWindowShop")
public class MainWindowShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < GoodsStorage.getListOfGoods().size(); i++) {
            if (req.getSession().getAttribute("msg" + i) != null){
                req.getSession().setAttribute("msg" + i,"");
            }
        }
        getServletContext().getRequestDispatcher("/Shop/mainWindowStore.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("maxGoods",GoodsStorage.getListOfGoods().size());
        for (int i = 0; i < GoodsStorage.getListOfGoods().size(); i++) {
            if (req.getSession().getAttribute("msg" + i) != null){
                req.getSession().setAttribute("msg" + i,"");
            }
        }
        getServletContext().getRequestDispatcher("/Shop/mainWindowStore.jsp").forward(req,resp);
    }
}
