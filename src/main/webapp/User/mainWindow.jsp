<%@ page import="db.ConnectionDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Window page</title>
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
    <h1>You have successful entry</h1>
    <h2>Have a pleasure using our service :)</h2>
    <p><a href="/mainWindowShop">Go to the shop</a></p>
    <p><a href="/">Exit you account</a></p>
</div>
</body>
</html>
