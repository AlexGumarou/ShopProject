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
</div>
<div style="text-align: center;">
    <h2>Here is you order:</h2>
    </div>
<p>
<p>
<p>
<p>

<div style="text-align: center;">
<form method="post" action="/choise">
    <p><b>Choise your way of delivery</b></p>
    <p><input name="wayOf" type="radio" value="pickUp"> Pick up the goods from the shop</p>
    <p><input name="wayOf" type="radio" value="delivery"> Delivery to your home</p>
   <p><input type="submit" value="Choose"></p>
</form>
</div>
</body>
</html>
