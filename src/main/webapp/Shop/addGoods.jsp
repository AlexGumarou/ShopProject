<%@ page import="db.ConnectionDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
            <%
        if (session.getAttribute("name").equals(ConnectionDB.getInstance().getAllUsers().get(0).getName()) &&
                session.getAttribute("login").equals(ConnectionDB.getInstance().getAllUsers().get(0).getLogin())){
            out.print("<a href=\"/dataAdmin\">" + session.getAttribute("name") + "</a></h4>");
        } else {
            out.print("<a href=\"/data\">" + session.getAttribute("name") + "</a></h4>");
        }
        %>
</div>
<div style="text-align: center;">
    <form name="test" method="post" action="/addGoods">
        <table border="0" align="center">
            <tr>
                <th></th>
                <th></th>
            </tr>
            <tr><td><input type="text" name="name" size="40"></td>
                <td>Add name</td>
            </tr>
            <tr><td><input type="text" name="description" size="40"></td>
                <td>Add description</td>
            </tr>
            <tr><td><input type="text" name="quantity" size="40"></td>
                <td>Add quantity</td>
            </tr>
            <tr><td><input type="text" name="price" size="40"></td>
                <td>Add price</td>
            </tr>
            </tr>

        </table>
        <br>

        <input type="submit" size="100" value="Add goods">
    </form>

</div>
</body>
</html>
