<%@ page import="java.util.List" %>
<%@ page import="ru.alexkm07.spdata.model.Order" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>Orders list</h3>");
%>
<a href="order">Add new order</a>
<style type="text/css">
    TABLE {
        width: 800px; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid black; /* Параметры рамки */
    }
    TH {
        background: #b0e0e6; /* Цвет фона */
    }
</style>
<table>
    <tr>
        <th>Number</th>
        <th>Date</th>
        <th>Customer</th>
        <th>Amount</th>
    </tr>
    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        for(Order order:orders){
            out.println("<tr>");
            out.println(String.format("<td>%s</td>",order.getId()));
            out.println(String.format("<td>%s</td>",order.getDate()));
            out.println(String.format("<td>%s</td>",order.getCustomer().getName()));
            out.println(String.format("<td>%s</td>",order.getTotalAmount()));
            out.println(String.format("<td><a href=editorder?id=%s>%s</a></td>",order.getId(),"Edit"));
            out.println(String.format("<td><a href=deleteorder?id=%s>%s</a></td>",order.getId(),"Delete"));
            out.println(" </tr>");
        }
    %>

</table>
</body>
</html>