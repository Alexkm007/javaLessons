<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit customer</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>Edit customer</h3>");
%>
<form action = "editcustomer" method = "POST">
    Name:    <input type = "text" maxlength=255 style=position:absolute;left:8%; name = "name" value=<%=request.getAttribute("name_customer")%>>
    <br />
    Address: <input type = "text" maxlength=1024 style=position:absolute;left:8%;  name = "address" value=<%=request.getAttribute("address_customer")%>>
    <br />
   <input type = "hidden" name = "id" value=<%=request.getAttribute("id_customer")%>>
    <br />
    <input type = "submit" value = "save" />
</form>
</body>
</html>