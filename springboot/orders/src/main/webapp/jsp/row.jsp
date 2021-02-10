<%@ page import="java.util.List" %>
<%@ page import="ru.alexkm07.spdata.model.Order" %>
<%@ page import="ru.alexkm07.spdata.model.Product" %>
<%@ page import="ru.alexkm07.spdata.model.OrderRow" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New order</title>
</head>
<body>

<a href="/">Home</a>
<br />
<% out.println ("<h3>Add product</h3>");%>
<%
    Long id = (Long) request.getAttribute("id");
    OrderRow row = (OrderRow) request.getAttribute("row");
%>
<form>
         Product: </strong>

        <input type = "hidden"  name = "order_id" value=<%=id%>>
        <input type = "hidden"  name = "id" <%
                if(row != null) {
                    out.println(" value="+row.getId());
                    }else {out.println(" value=0") ;
                }
        %>>
        <select name="product">
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for(Product product:products){
                    if(row != null && row.getProduct().getId().equals(product.getId())){
                        out.println(String.format("<option selected value=%d>%s</option>",product.getId(),product.getName()));
                    }else{
                    out.println(String.format("<option value=%d>%s</option>",product.getId(),product.getName()));
                }
                }
            %>
        </select>
        Price: <input type = "number"  name = "price"<%
        if(row != null) out.println(" value="+row.getPrice());
        %>">
        Quantity: <input type = "number"  name = "quantity" <%
        if(row != null)out.println("value="+row.getQuantity());
        %>>
       <input formaction="saverow" formmethod="post" type="submit" value="save" />
    </form>
</body>
</html>