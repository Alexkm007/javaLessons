<%--
  Created by IntelliJ IDEA.
  User: aleksei
  Date: 04.02.2021
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%
    String[] times = new String[] { "summer", "autumn", "winter", "spring" };
    request.setAttribute("items", times);
%>
<h3>For each loop</h3>
<ur>
    <c:forEach var="item" items="${items}">
        <li>
            <a> ${item}</a>
        </li>
    </c:forEach>
</ur>

<h3>For each with counter</h3>
<table>
    <thead>
    <tr>
        <th>item</th>
        <th>index</th>
        <th>count</th>
        <th>first</th>
        <th>last</th>
        <th>step</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}" step="1" varStatus="status">
        <tr>
            <th>${item}</th>
            <th>${status.index}</th>
            <th>${status.count}</th>
            <th>${status.first}</th>
            <th>${status.last}</th>
            <th>${status.step}</th>
        </tr>
    </c:forEach>

    </tbody>

</table>

<h3> For tokens loop </h3>
<ui>
<c:forTokens items="Hi, Hi hi hu, lolo ha, sec" delims="," var = "word">
    <li>${word}</li>
</c:forTokens>
</ui>

</body>
</html>
