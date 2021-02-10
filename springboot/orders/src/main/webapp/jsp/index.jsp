<%@ page import="java.util.List" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home work</title>
</head>
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
<% out.println ("<h3>Welcome to Home work</h3>");
%>
<table>
    <tr>
        <%
            List<String[]> headlines = (List<String[]>) request.getAttribute("headlines");
            for(String[] headline:headlines){
                out.println(String.format("<th><a href=%s>%s</a></th>",headline[0],headline[1]));
            }
        %>
    </tr>
</table>
</body>
</html>