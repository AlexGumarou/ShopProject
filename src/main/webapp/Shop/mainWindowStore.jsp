<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
        <a href="/dataCheck">${nameUser}</a>
        <p><a href="/basket">You basket here</a></p></h4>
</div>
<div style="text-align: center;">
    <table border="0" align="center">
        <caption>List of Goods</caption>
<td><table border="0" align="center">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${listGoods}" var="item"  >
        <tr><td> ${item.name}</td>
        <td> ${item.description}</td>
        <td> ${item.quantity}</td>
        <td> ${item.price}</td>
    </c:forEach>
</table>
    <td><table border="0" align="center">
        <tr>
            <th>Enter your order</th>
        </tr>
        <c:forEach var="i" begin="0" end="${max}" step="1" >
            <form name="test" method="post" action="/basket">
            <tr><td><input type="text" name = "goods ${i}" size="15"></td>
        </c:forEach>
    </table>
    </table>
    <br>
<input type="submit" size="100" value="Add Goods to the basket">
</form>
</div>
</body>
</html>
