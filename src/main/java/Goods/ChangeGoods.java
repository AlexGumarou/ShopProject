package Goods;

import dao.GoodsDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeGoods")
public class ChangeGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GoodsDao goodsDao = new GoodsDao();
        for (int i = 0; i< goodsDao.getAllGoods().size(); i++) {
            int id = goodsDao.getAllGoods().get(i).getId();
            if (req.getParameter("button").equals("Delete " + i)) {
                goodsDao.deleteGoods(id);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
