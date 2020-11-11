<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 11.11.2020
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form name="test" method="post" action="/login">
    <h1>WebProgect common</h1>
    <p><b>Enter login:</b><br>
        <input type="text" name="login" size="40">
    </p>
    <p><b>Enter pass:</b><br>
        <input type="text" name="pass" size="40">
    </p>
    <p><input type="submit" value="Send">
</form>

<p><a href="/registration">Registration</a></p>
</body>
</html>
