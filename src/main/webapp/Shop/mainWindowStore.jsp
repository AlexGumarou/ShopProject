<%@ page import="Goods.GoodsStorage" %>
<%@ page import="login.ListOfThePersons" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        h4><p><a href="/Order/Basket">You basket here</a></p></h4>
</div>
<table border="1">

    <caption>List of Goods</caption>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Enter your value</th>
    </tr>
<%
    for (int i = 0; i < GoodsStorage.getListOfGoods().size(); i++){
        out.print("<tr><td>" + GoodsStorage.getListOfGoods().get(i).getName() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getDescription() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getQuantity() + "</td>");
        out.print("<td>" + GoodsStorage.getListOfGoods().get(i).getPrice() + "</td>");
        out.print("<td><input type=\"text\" name = " + "\"" + GoodsStorage.getListOfGoods().get(i).getName() +
        "\"" + " size=\"10\"></td></tr>");
        }
%>
</table>
<form name="test" method="post" action="/Order/Basket">
<p><input type="submit" size="100" value="Add goods to the basket">
</form>
</body>
</html>
