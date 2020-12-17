<%@ page import="java.util.List" %>
<%@ page import="entity.Orders" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.OrderDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
        <a href="/dataCheck">${name}</a></h4>
</div>

<div style="text-align: center;">
    <table border="1" align="center">

        <br>
        <tr>
            <th>Order</th>
            <th>Date</th>
            <th>Order description</th>
        </tr>
                <%
                    OrderDao orderDao = new OrderDao();
                    List<Orders> list = orderDao.getAllOrders();
        if (list.isEmpty()){
            out.print("Нет заказов на данный момент" + "<br>");
        } else {
            for (Orders orders : list) {
                if (orders.getUsers().equals(request.getSession().getAttribute("login"))) {
                    out.print("<tr><td>" + orders.getId() + "</td>");
                    out.print("<td>" + orders.getDate() + "</td>");
                    out.print("<td>" + orders.getOrders() + "</td></tr>");
                }
            }
        }
%>
    </table>

</body>
</html>
