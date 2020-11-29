<%@ page import="Goods.GoodsStorage" %>
<%@ page import="login.ListOfThePersons" %>
<%@ page import="db.ConnectionDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
            <%
        if (session.getAttribute("name").equals(ConnectionDB.getInstance().getAllUsers().get(0).getName()) &&
                session.getAttribute("login").equals(ConnectionDB.getInstance().getAllUsers().get(0).getLogin())){
            out.print("<a href=\"/dataAdmin\">" + session.getAttribute("name") + "</a></h4>");
        } else {
            out.print("<a href=\"/data\">" + session.getAttribute("name") + "</a></h4>");
        }
        %>
</div>
<div style="text-align: center;">
<%
    for (int i = 0; i < ConnectionDB.getInstance().getAllGoods().size(); i++) {
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
        int totalValue = 0;
        for (int i = 0; i < ConnectionDB.getInstance().getOneOrder().size(); i++){
            String name = ConnectionDB.getInstance().getOneOrder().get(i).getName();
            int price = ConnectionDB.getInstance().getOneOrder().get(i).getPrice();
            int quantity = ConnectionDB.getInstance().getOneOrder().get(i).getQuantity();
            int sum = ConnectionDB.getInstance().getOneOrder().get(i).getSum();
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
