<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title="Users"/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr>
            <th><@spring.message "label.users.name"/></th>
            <th><@spring.message "label.users.active"/></th>
            <th><@spring.message "label.users.email"/></th>
            <th><@spring.message "label.users.roles"/></th>
            <th></th><th></th></tr>
        </thead>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <#if user.active>
                <td>+</td>
            <#else>
                <td>-</td>
            </#if>
            <td>${user.email}</td>
            <td>
                <#list user.roles as role>
                ${role}
                </#list>
            </td>
            <td>
                <a href="/users/edit/#{user.id}" class="btn btn-outline-primary" role="button" aria-pressed="true"><@spring.message "label.accounts.edit"/></a>
            </td>
            <td>
                <a href="/users/delete/#{user.id}" class="btn btn-outline-danger" role="button" aria-pressed="true"><@spring.message "label.accounts.delete"/></a>
            </td>
        </tr>
        </#list>
    </table>
    <a href="/users/add" class="btn btn-outline-primary" role="button" aria-pressed="true"><@spring.message "label.users.add"/></a>
<@m.scriptOn/>
</body>
</html>