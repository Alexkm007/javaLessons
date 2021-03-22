<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title="Exchange history"/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr>
            <th><@spring.message "label.exchanges.date"/></th>
            <th><@spring.message "label.exchanges.currency"/></th>
            <th><@spring.message "label.exchanges.rate"/></th>
            <th><@spring.message "label.exchanges.ratio"/></th>
            <th></th><th></th></tr>
        </thead>
        <#list exchangerate as row>
        <tr><td>${row.date?date}</td>
            <td>${row.currency}</td>
            <td>#{row.rate}</td>
            <#if row.ratio??>
            <td>#{row.ratio}</td>
            <#else>
              <td>1.00</td>
            </#if>

            <#if isAdmin>
            <td>
                <a href="/exchange/delete/${row.id}" class="btn btn-outline-danger" role="button" aria-pressed="true">
                    <@spring.message "label.exchanges.delete"/></a>
            </td>
            </#if>
        </tr>
        </#list>
    </table>
    <#if isAdmin>
    <a href="/exchange/add" class="btn btn-outline-primary" role="button" aria-pressed="true">
        <@spring.message "label.exchanges.add"/></a>
    </#if>
</div>
<@m.scriptOn/>
</body>
</html>
