<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align:center;">
    <h2>This is your personal data</h2>
    <h4>You login is <%= session.getAttribute("login") %></h4>
    <h4>You pass is <%= session.getAttribute("pass") %></h4>
    <h4>You name is <%= session.getAttribute("name") %></h4>
    <h4>You surname is <%= session.getAttribute("surname") %></h4>
</div>
<div style="text-align: center;">
    <p><a href="/mainWindow">Go to the main window</a></p>
    <p><a href="/userStore">Go to the users Storage</a></p>
    <p><a href="/">Exit you account</a></p>
</div>
</body>
</html>
