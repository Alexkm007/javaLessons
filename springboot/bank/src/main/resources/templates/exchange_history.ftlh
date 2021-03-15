<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Exchange history"/>
<body>
<@menu.fullmenu/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr><th>Date</th><th>Currency</th><th>Rate</th><th>Ratio</th><th></th><th></th></tr>
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

            <#if isadmin>
            <td>
                <a href="/exchange/delete/${row.id}" class="btn btn-outline-danger" role="button" aria-pressed="true">Delete</a>
            </td>
            </#if>
        </tr>
        </#list>
    </table>
    <#if isadmin>
    <a href="/exchange/add" class="btn btn-outline-primary" role="button" aria-pressed="true">Add new record</a>
    </#if>
</div>
<@m.scriptOn/>
</body>
</html>
