<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 12.11.2020
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h3>Welcome, <%= session.getAttribute("login") %></h3>
</div>
<div style="text-align:center;">
    <h4>You login is <%= session.getAttribute("login") %></h4>
    <h4>You pass is <%= session.getAttribute("pass") %></h4>
    <h4>You name is <%= session.getAttribute("name") %></h4>
    <h4>You surname is <%= session.getAttribute("surname") %></h4>
</div>
<div style="text-align: center;">
    <p><a href="/mainWindow">back</a></p>
    <p><a href="/">Exit you account</a></p>
</div>
</body>
</html>
