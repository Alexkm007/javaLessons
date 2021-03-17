<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Users"/>
<body>
<@menu.fullmenu/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr><th>number</th><th>date</th><th>from</th><th>to</th><th>amount</th><th></th><th></th></tr>
        </thead>
        <#list transactions as tr>
        <tr>
            <td>#{tr.id}</td>
            <td>${tr.date?date}</td>
            <td>${tr.fromAccount.name}</td>
            <td>${tr.toAccount.name}</td>
            <td>${tr.amount}</td>
            <td>
                <a href="/transactions/edit/#{tr.id}" class="btn btn-outline-primary" role="button" aria-pressed="true">Edit</a>
            </td>
            <td>
                <a href="/transactions/delete/#{tr.id}" class="btn btn-outline-danger" role="button" aria-pressed="true">Delete</a>
            </td>
        </tr>
        </#list>
    </table>
    <a href="/transactions/add" class="btn btn-outline-primary" role="button" aria-pressed="true">Add new transaction</a>
<@m.scriptOn/>
</body>
</html>