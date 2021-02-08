<%@ page import="java.util.Date" %>
<%@ page import="ru.alexkm07.spdata.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="ru.alexkm07.spdata.model.OrderRow" %>
<%@ page import="ru.alexkm07.spdata.model.Order" %>
<%@ page import="java.util.Set" %>
<%@ page import="ru.alexkm07.spdata.model.Product" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New order</title>
</head>
<body>

<a href="/">Home</a>
<br />
<% out.println ("<h3>New order</h3>");
%>
<%
    Order order = (Order) request.getAttribute("order");
%>

    <form>
    Date: <input type = "text"  name = "date" style="text-align: left" value="
            <%
                Date date = new Date();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                if(order != null){
                   date = order.getDate();
                }
                out.println(format1.format(date));
                %>" readonly>

        <input type = "hidden" name = "id" value=
        <%
            if(order != null){
                   out.println(order.getId());
                }else  out.println(0);
        %>>

    <strong>Select customer</strong>
    <select name="customer">
       <%
           List<Customer> customers = (List<Customer>) request.getAttribute("customers");
           for(Customer customer:customers){
               if(order != null &&
                       order.getCustomer().getId().equals(customer.getId())){
                       out.println(String.format("<option selected value=%d>%s</option>",customer.getId(),customer.getName()));
                   }
               out.println(String.format("<option value=%d>%s</option>",customer.getId(),customer.getName()));
           }
       %>
    </select>
    <ul>
        <li><p><b>Total amount:</b>
            <%
                if(order != null) {
                    out.println(order.getTotalAmount());
                }else{
                    out.println(0.00);
                }
            %>
        </p></li>
        <li><p><b>Total quantity:</b>
            <%
                if(order != null) {
                    out.println(order.getTotalQuantity());
                }else{
                    out.println(0.00);
                }
            %>
        </p></li>
    </ul>
    <input formaction="neworder" formmethod="post" type="submit" value="add" />
    <br/>
    <br/>


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
        <table>
        <tr>
            <th>id</th>
            <th>product</th>
            <th>price</th>
            <th>quantity</th>
            <th>amount</th>
        </tr>

        <%
            Set<OrderRow> orderRows = (Set<OrderRow>) request.getAttribute("orderrows");
            if(orderRows == null){
                return;
            }
            for(OrderRow orderRow:orderRows){
                out.println("<tr>");
                out.println(String.format("<td>%d</td>",orderRow.getId()));
                out.println(String.format("<td>%s</td>",orderRow.getProduct().getName()));
                out.println(String.format("<td>%d</td>",orderRow.getPrice()));
                out.println(String.format("<td>%d</td>",orderRow.getQuantity()));
                out.println(String.format("<td>%d</td>",orderRow.getAmount()));
                out.println(String.format("<td><a href=editcustomer?id=%s>%s</a></td>",orderRow.getId(),"Edit"));
                out.println(String.format("<td><a href=deletecustomer?id=%s>%s</a></td>",orderRow.getId(),"Delete"));
                out.println(" </tr>");
            }
        %>
        </table>
        <input formaction="addrow" formmethod="post" type="submit" value="add row" />
    </form>
</body>
</html>