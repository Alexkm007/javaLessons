<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New customer</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>New customer</h3>");
%>
<form action = "newcustomer" method = "POST">
    Name:    <input type = "text" style=position:absolute;left:8%; name = "name">
    <br />
    Address: <input type = "text" style=position:absolute;left:8%;  name = "address">
    <br />
    <input type = "submit" value = "add" />
</form>
</body>
</html>