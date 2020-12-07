package Goods;

import dao.GoodsDao;
import dao.OrderDao;
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
        OrderDao orderDao = new OrderDao();
        orderDao.deleteOneOrder();
        GoodsDao goodsDao = new GoodsDao();
        req.setAttribute("maxGoods", goodsDao.getAllGoods());
        for (int i = 0; i < goodsDao.getAllGoods().size(); i++) {
            if (req.getSession().getAttribute("msg" + i) != null){
                req.getSession().setAttribute("msg" + i,"");
            }
        }
        getServletContext().getRequestDispatcher("/Shop/mainWindowStore.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        orderDao.deleteOneOrder();
        GoodsDao goodsDao = new GoodsDao();
        req.setAttribute("maxGoods", goodsDao.getAllGoods());
        for (int i = 0; i < goodsDao.getAllGoods().size(); i++) {
            if (req.getSession().getAttribute("msg" + i) != null){
                req.getSession().setAttribute("msg" + i,"");
            }
        }
        getServletContext().getRequestDispatcher("/Shop/mainWindowStore.jsp").forward(req,resp);
    }
}
