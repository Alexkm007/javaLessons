<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title="Users"/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr><th><@spring.message "label.transactions.number"/></th>
            <th><@spring.message "label.transactions.date"/></th>
            <th><@spring.message "label.transactions.from"/></th>
            <th><@spring.message "label.transactions.to"/></th>
            <th><@spring.message "label.transactions.amount"/></th>
            <th></th><th></th></tr>
        </thead>
        <#list transactions as tr>
        <tr>
            <td>#{tr.id}</td>
            <td>${tr.date?date}</td>
            <td>${tr.fromAccount.name}</td>
            <td>${tr.toAccount.name}</td>
            <td>${tr.amount}</td>
            <td>
                <a href="/transactions/edit/#{tr.id}" class="btn btn-outline-primary" role="button" aria-pressed="true"><@spring.message "label.accounts.edit"/></a>
            </td>
            <td>
                <a href="/transactions/delete/#{tr.id}" class="btn btn-outline-danger" role="button" aria-pressed="true"><@spring.message "label.accounts.delete"/></a>
            </td>
        </tr>
        </#list>
    </table>
    <a href="/transactions/add" class="btn btn-outline-primary" role="button" aria-pressed="true"><@spring.message "label.transactions.add"/></a>
<@m.scriptOn/>
</body>
</html>