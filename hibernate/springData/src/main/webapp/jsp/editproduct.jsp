<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>Edit product</h3>");
%>
<form action = "editproduct" method = "POST">
    Name:    <input type = "text" name = "name" value=<%=request.getAttribute("name_product")%>>
    <br />
   <input type = "hidden" name = "id" value=<%=request.getAttribute("id_product")%>>
    <br />
    <input type = "submit" value = "save" />
</form>
</body>
</html>