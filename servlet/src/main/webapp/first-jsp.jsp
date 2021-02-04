<%--
  Created by IntelliJ IDEA.
  User: aleksei
  Date: 03.02.2021
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ru.alexkm07.User" %>
<%@ page import="java.util.List" %>
>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Hello JSP</h1>
<%
    response.getWriter().write("First message");
    out.println("Second message");
%>
<br/>
<%=request.getRequestURL()%>
<br/>
<%=LocalDateTime.now()%>
<hr/>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    User userl = users.get(0);%>
<b><%=userl.getName()%><b/>
<br/>
    <i><%=userl.getCountry()%></i>
<br/>
    <u><%=userl.getAge()%></u>
    <br/>
    <table>
        <% for (User user : users) {%>
        <tr>
            <td><%= user.getName() %></td>
            <td>
                <% if (user.getCountry().equals("Vietnam")) { %>
                <b><%= user.getCountry() %></b>
                <% } else { %>
                <%= user.getCountry() %>
                <% } %>
            </td>
            <td><%= user.getAge() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
