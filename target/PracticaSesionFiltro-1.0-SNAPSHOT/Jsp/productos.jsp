<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 22/10/2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Productos</title>
</head>
<body>
<h1>Lista de productos</h1>
<form method="post" action="cesta">
    <c:forEach var="producto" items="${productos}">
        <input type="checkbox" name="productoComprado"
               value="<c:out value="${producto.getNombre()}"/>">
        <c:out value="${producto.getNombre()}"/> <br>
    </c:forEach>
    <br>
    <input type="submit" value="Añandir a la cesta" style="text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;">
</form>
<br>
</body>
</html>
