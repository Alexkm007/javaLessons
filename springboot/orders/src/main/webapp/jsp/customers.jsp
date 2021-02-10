<%@ page import="java.util.List" %>
<%@ page import="ru.alexkm07.spdata.model.Customer" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customers</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>Customers list</h3>");
%>
<style type="text/css">
    TABLE {
        width: 600px; /* Ширина таблицы */
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
<body>
<a href="/customer/newcustomer">Add new customer</a>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Address</th>
    </tr>
        <%
            List<Customer> customers = (List<Customer>) request.getAttribute("customers");
            for(Customer customer:customers){
                out.println("<tr>");
                out.println(String.format("<td>%s</td>",customer.getId()));
                out.println(String.format("<td>%s</td>",customer.getName()));
                out.println(String.format("<td>%s</td>",customer.getAddress()));
                out.println(String.format("<td><a href=editcustomer?id=%s>%s</a></td>",customer.getId(),"Edit"));
                out.println(String.format("<td><a href=deletecustomer?id=%s>%s</a></td>",customer.getId(),"Delete"));
                out.println(" </tr>");
            }
//            List<String[]> headlines = (List<String[]>) request.getAttribute("headlines");
//            for(String[] headline:headlines){
//                out.println(String.format("<th><a href=%s>%s</a></th>",headline[0],headline[1]));
//            }
        %>

</table>
</body>
</html>