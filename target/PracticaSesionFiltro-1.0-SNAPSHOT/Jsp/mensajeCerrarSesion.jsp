<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 02/11/2020
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: left;
font-family: Arial;
font-size: 30px;
COLOR: #1278BF;
text-shadow: 0px 0px 9px #508AD3;"><c:out value="${mensaje}"/></h1>

<form action="logout" method="post">

    <input type="submit" value="Cerrar Sesion" style="text-decoration: none;
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
