<%@ page import="db.ConnectionDB" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: А
  Date: 20.11.2020
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
            <%
            UserDao userDao = new UserDao();
        if (session.getAttribute("name").equals(userDao.getAllUsers().get(0).getName()) &&
                session.getAttribute("login").equals(userDao.getAllUsers().get(0).getLogin())){
            out.print("<a href=\"/dataAdmin\">" + session.getAttribute("name") + "</a></h4>");
        } else {
            out.print("<a href=\"/data\">" + session.getAttribute("name") + "</a></h4>");
        }
        %>
</div>
<div style="text-align: center;">
    <h2>Your order is accepted</h2>

    <p><a href="/mainWindowShop">back to the Shop</a></p>
</div>
</body>
</html>
