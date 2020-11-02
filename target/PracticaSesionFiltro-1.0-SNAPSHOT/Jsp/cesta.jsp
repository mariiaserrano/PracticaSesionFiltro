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
    <title>Cesta de la compra</title>
</head>
<body>
<h1>Articulos en la cesta</h1>
<table border="2">

    <c:forEach items="${productoComprado}" var="item">
        <tr>
            <td style="font-family: 'Comic Sans MS'">
                <c:out value="${item.getNombre()}"/>
            </td>
        </tr>
    </c:forEach>

    <c:out value="${mensaje}"/>

</table>

<br>

<br>
<br>
<form method="post" action="opciones">
    <input type="submit" name="op" value="Anadir" style="text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;">
    <input type="submit" name="op" value="Comprar" style="text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;">
    <input type="submit" name="op" value="Limpiar" style="text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;">

</form>

<form method="post" action="logout" style="alignment: center">
    <input type="submit" value="Cerrar Sesion"  style="text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    background-color: #1883ba;
    border-radius: 6px;
    border: 2px solid #0016b0;">
</form>
</body>

</html>
