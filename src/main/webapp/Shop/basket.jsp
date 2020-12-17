<%@ page import="dao.GoodsDao" %>
<%@ page import="dao.OrderDao" %>
<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
        <a href="/dataCheck">${nameUser}</a></h4>
</div>
<div style="text-align: center;">
<%
    GoodsDao goodsDao = new GoodsDao();
    for (int i = 0; i < goodsDao.getAllGoods().size(); i++) {
        if (request.getSession().getAttribute("msg" + i) != null){
            String msg = (String) session.getAttribute("msg" + i);
            out.print("<font color=\"red\">" + msg + "</font>");
        }
    }
%>
</div>
<div style="text-align: center;">
    <table border="1" align="center">
        <h4><caption>Here is you Order:</caption></h4>
        <br>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sum</th>
    </tr>
    <%
    OrderDao orderDao = new OrderDao();
    List<Order> list = orderDao.getOneOrder();
        int totalValue = 0;
        for (int i = 0; i < list.size(); i++){
            String name = list.get(i).getName();
            int price = list.get(i).getPrice();
            int quantity = list.get(i).getQuantity();
            int sum = quantity*price;
            if (quantity>0){
            out.print("<tr><td>" + name + "</td>");
            out.print("<td>" + price + "</td>");
            out.print("<td>" + quantity + "</td>");
            out.print("<td>" + sum + "</td>");
            totalValue +=sum;
            }
        }
        out.print("</table><br>");
        out.print("<h4>" + "Total value is: " + totalValue + "<br>");
    %>
    </div>
<div style="text-align: center;">
    <br>
        <p><a href="/mainWindowShop">CHANGE YOUR ORDER</a></p>
<form method="post" action="/choise">
    <p><b>Choise your way of delivery</b></p>
    <p><input name="wayOf" type="radio" value="pickUp"> Pick up the Goods from the shop</p>
    <p><input name="wayOf" type="radio" value="delivery"> Delivery to your home</p>
   <p><input type="submit" value="MAKE AN ORDER"></p>
</form>
</div>
</body>
</html>
