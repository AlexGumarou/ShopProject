<%@ page import="login.PersonalData" %>
<%@ page import="login.ListOfThePersons" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align:center;">
    <h2>This is your personal data</h2>
<%--    <%--%>
<%--        for (PersonalData data : ListOfThePersons.getList()){--%>
<%--            out.print("<h3>You login is " + data.getLogin() + "</h3>");--%>
<%--            out.print("<h3>You pass is " + data.getPass() + "</h3>");--%>
<%--            out.print("<h3>You name is " + data.getName() + "</h3>");--%>
<%--            out.print("<h3>You surname is " + data.getSurname() + "</h3>");--%>
<%--            out.print("<h3>You address is " + data.getAddress() + "</h3>");--%>
<%--            out.print("<h3>You email is " + data.getEmail() + "</h3>");--%>
<%--            out.print("<h3>You phone is " + data.getPhone() + "</h3>");--%>
<%--        }--%>
<%--    %>--%>
    <h3>You login is <%= session.getAttribute("login") %></h3>
    <h3>You pass is <%= session.getAttribute("pass") %></h3>
    <h3>You name is <%= session.getAttribute("name") %></h3>
    <h3>You surname is <%= session.getAttribute("surname") %></h3>
    <h3>You surname is <%= session.getAttribute("address") %></h3>
    <h3>You surname is <%= session.getAttribute("email") %></h3>
    <h3>You surname is <%= session.getAttribute("phone") %></h3>

</div>
<div style="text-align: center;">
    <p><a href="/mainWindow">Go to the main window</a></p>
    <p><a href="/orderHistory">Go to the history of orders</a></p>
    <p><a href="/">Exit you account</a></p>
</div>
</body>
</html>
