<%@ page import="Goods.GoodsStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome, <a href="/data"> <%= session.getAttribute("name") %></a></h4>
</div>
<div style="text-align: center;">
    <h2>Here is you order:</h2>
    </div>
</body>
</html>
