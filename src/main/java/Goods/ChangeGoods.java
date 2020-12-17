package Goods;

import dao.GoodsDao;
import entity.Goods;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/changeGoods")
public class ChangeGoods extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> list = goodsDao.getAllGoods();
        for (int i = 0; i< list.size(); i++) {
            int id = list.get(i).getId();
            if (req.getParameter("button").equals("Delete " + i)) {
                goodsDao.deleteGoods(id);
                resp.sendRedirect("/modifyGoods");
            }
        }
    }
}
