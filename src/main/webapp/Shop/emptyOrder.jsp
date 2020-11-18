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
    <h3>You do not add any goods</h3>
    <div style="text-align: center;">
        <p><a href="/mainWindowShop">Back to the shop</a></p>
    </div>
    </div>
</body>
</html>
