<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title="Accounts"/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr><th><@spring.message "label.account.name"/></th>
            <th><@spring.message "label.accounts.owner"/></th>
            <th><@spring.message "label.account.currency"/></th>
            <th><@spring.message "label.accounts.balance"/></th>
            <th><@spring.message "label.account.date"/></th>
            <th></th><th></th>
        </tr>
        </thead>
        <#list accounts as ac>
        <tr>
            <td>${ac.name}</td>
            <td>${ac.owner.username}</td>
            <td>${ac.currency}</td>
            <td>${ac.balance}</td>
            <td>${ac.openingDate?date}</td>
            <td>
                <a href="/accounts/edit/#{ac.id}" class="btn btn-outline-primary" role="button" aria-pressed="true">
                    <@spring.message "label.accounts.edit"/></a>
            </td>
            <td>
                <a href="/accounts/delete/#{ac.id}" class="btn btn-outline-danger" role="button" aria-pressed="true">
                    <@spring.message "label.accounts.delete"/></a>
            </td>
        </tr>
        </#list>
    </table>
    <a href="/accounts/add" class="btn btn-outline-primary" role="button" aria-pressed="true"><@spring.message "label.accounts.add"/></a>

<@m.scriptOn/>
</body>
</html>