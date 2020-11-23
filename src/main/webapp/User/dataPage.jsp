<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align:center;">
    <h2>This is your personal data</h2>

    <h3>You login is <%= session.getAttribute("login") %></h3>
    <h3>You pass is <%= session.getAttribute("pass") %></h3>
    <h3>You name is <%= session.getAttribute("name") %></h3>
    <h3>You surname is <%= session.getAttribute("surname") %></h3>
    <h3>You address is <%= session.getAttribute("address") %></h3>
    <h3>You email is <%= session.getAttribute("email") %></h3>
    <h3>You phone is <%= session.getAttribute("phone") %></h3>

</div>
<div style="text-align: center;">
    <form name="test" method="post" action="/mainWindow">
        <input type="submit" value="Go to the main window">
    </form>
    <form name="test" method="post" action="/orderHistory">
        <input type="submit" value="Go to the history of orders">
    </form>
    <form name="test" method="post" action="/">
        <input type="submit" value="Exit you account">
    </form>
</div>
</body>
</html>
