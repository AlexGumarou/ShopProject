<%@ page import="dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Window page</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
        <a href="/dataCheck">${name}</a></h4>
</div>
<div style="text-align: center;">
    <h1>You have successful entry</h1>
    <h2>Have a pleasure using our service :)</h2>
    <p><a href="/mainWindowShop">Go to the shop</a></p>
    <p><a href="/">Exit you account</a></p>
</div>
</body>
</html>
