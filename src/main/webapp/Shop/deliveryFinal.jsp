<%@ page import="dao.UserDao" %>
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
    <h2>Your order is accepted</h2>

    <p><a href="/mainWindowShop">back to the Shop</a></p>
</div>
</body>
</html>
