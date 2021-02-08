<%@ page import="java.util.List" %>
<%@ page import="ru.alexkm07.spdata.model.Order" %>
<%@ page import="ru.alexkm07.spdata.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New order</title>
</head>
<body>

<a href="/">Home</a>
<br />
<% out.println ("<h3>Add product</h3>");
%>
<%
    Order order = (Order) request.getAttribute("order");
%>

<form>
         Product: </strong>

        <input type = "hidden"  name = "id" value="%{id}">
        <select name="product">
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for(Product product:products){
                    out.println(String.format("<option value=%d>%s</option>",product.getId(),product.getName()));
                }
            %>
        </select>
        Price: <input type = "number"  name = "price">
        Quantity: <input type = "number"  name = "quantity">
       <input formaction="addrow" formmethod="post" type="submit" value="add row" />
    </form>
</body>
</html>