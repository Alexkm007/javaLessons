<%@ page import="java.util.List" %>
<%@ page import="ru.alexkm07.spdata.model.Product" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<a href="/">Home</a>
<br />
<% out.println ("<h3>Products list</h3>");
%>
<style type="text/css">
    TABLE {
        width: 350px; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    TD, TH {
        padding: 1px; /* Поля вокруг содержимого таблицы */
        border: 1px solid black; /* Параметры рамки */
    }
    TH {
        background: #b0e0e6; /* Цвет фона */
    }
</style>
<a href="/product/newproduct">Add new product</a>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        for(Product product:products){
            out.println("<tr>");
            out.println(String.format("<td>%s</td>",product.getId()));
            out.println(String.format("<td>%s</td>",product.getName()));
            out.println(String.format("<td><a href=editproduct?id=%s>%s</a></td>",product.getId(),"Edit"));
            out.println(String.format("<td><a href=deleteproduct?id=%s>%s</a></td>",product.getId(),"Delete"));
            out.println(" </tr>");
        }
    %>
</table>
</body>
</html>