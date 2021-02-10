<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New product</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>New product</h3>");
%>
<form action = "newproduct" method = "POST">
    Name: <input type = "text" name = "name">
    <br />
    <input type = "submit" value = "add" />
</form>
</body>
</html>