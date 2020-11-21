<%@ page import="Goods.GoodsStorage" %>
<%@ page import="login.ListOfThePersons" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="text-align: right;">
    <h4>Welcome,
            <% if (session.getAttribute("name").equals(ListOfThePersons.getList().get(0).getName()) &&
                session.getAttribute("login").equals(ListOfThePersons.getList().get(0).getLogin())){
            out.print("<a href=\"/dataAdmin\">" + session.getAttribute("name") + "</a></h4>");
        } else {
            out.print("<a href=\"/data\">" + session.getAttribute("name") + "</a></h4>");
        }
        %>
        <p><a href="/basket">You basket here</a></p></h4>
</div>
<div style="text-align: center;">
<table border="1" align="center">

    <caption>List of Goods</caption>
    <br>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Enter your value</th>
    </tr>
    <form name="test" method="post" action="/basket">
<%

    for (int i = 0; i < GoodsStorage.getListOfGoods().size(); i++){
        if (GoodsStorage.getListOfGoods().get(i).getQuantity()>0){
        out.print("<tr><td>" + GoodsStorage.getListOfGoods().get(i).getName() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getDescription() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getQuantity() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getPrice() + "</td>");
        out.print("<td><input type=\"text\" name = \"goods " + i + "\"" + "size=\"10\"></td></tr>");
        }
        }
%>
</table>
    <br>
<input type="submit" size="100" value="Add Goods to the basket">
</form>
</div>
</body>
</html>
