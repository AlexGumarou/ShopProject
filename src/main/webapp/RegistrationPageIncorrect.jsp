<%--
  Created by IntelliJ IDEA.
  User: А
  Date: 11.11.2020
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>

<form name="test" method="post" action="/registrationIncorrect">
    <div style="text-align: center;">
        <h1>May be we enter invalid login or password<br>
        Please try again</h1>

        <p><b>Enter login:</b><br>
            <input type="text" name="login" size="40">
        </p>
        <p><b>Enter pass:</b><br>
        <p><i>(It must have 1 Main letter, 1 number minimal)</i></p>
        <input type="text" name="pass" size="40">
        </p>
        <p><b>Enter your name:</b><br>
            <input type="text" name="name" size="40">
        </p>
        <p><b>Enter your surname:</b><br>
            <input type="text" name="surname" size="40">
        </p>
        <p><input type="submit" value="Register">
    </div>
</form>
<div style="text-align: center;">
    <p><a href="/">back</a></p>
</div>
</body>
</html>
