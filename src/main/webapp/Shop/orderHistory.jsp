<%@ page import="login.ListOfThePersons" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
            <% if (session.getAttribute("name").equals(ListOfThePersons.getList().get(0).getName()) &&
                session.getAttribute("login").equals(ListOfThePersons.getList().get(0).getLogin())){
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
        if (ListOfThePersons.getOrderList().isEmpty()){
            out.print("Нет заказов на данный момент" + "<br>");
        } else {
            for (int i = 0; i < ListOfThePersons.getOrderList().size(); i++) {
                if (ListOfThePersons.getOrderList().get(i).getUser().equals(request.getSession().getAttribute("login"))) {
                    out.print("<tr><td>" + ListOfThePersons.getOrderList().get(i).getIdOrder() + "</td>");
                    out.print("<td>" + ListOfThePersons.getOrderList().get(i).getTime() + "</td>");
                    out.print("<td>" + ListOfThePersons.getOrderList().get(i).getMap() + "</td></tr>");
                }
            }
        }
%>
    </table>

</body>
</html>
