<%@ page import="login.ListOfThePersons" %>
<%@ page import="java.util.List" %>
<%@ page import="Order.OrderStorage" %>
<%@ page import="db.ConnectionDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <table border="1" align="center">

        <br>
        <tr>
            <th>Order</th>
            <th>Time</th>
            <th>Order description</th>
        </tr>
                <%
        if (OrderStorage.getOrderList().isEmpty()){
            out.print("Нет заказов на данный момент" + "<br>");
        } else {
            for (int i = 0; i < OrderStorage.getOrderList().size(); i++) {
                if (OrderStorage.getOrderList().get(i).getUser().equals(request.getSession().getAttribute("login"))) {
                    out.print("<tr><td>" + OrderStorage.getOrderList().get(i).getIdOrder() + "</td>");
                    out.print("<td>" + OrderStorage.getOrderList().get(i).getTime() + "</td>");
                    out.print("<td>" + OrderStorage.getOrderList().get(i).getMap() + "</td></tr>");
                }
            }
        }
%>
    </table>

</body>
</html>
