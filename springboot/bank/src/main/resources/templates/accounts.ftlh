<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Accounts"/>
<body>
<@menu.fullmenu/>
<div class="container mt-2">
    <table class="table">
        <thead class="table-success">
        <tr><th>name</th><th>owner</th><th>currency</th><th>balance</th><th>opening date</th><th></th><th></th></tr>
        </thead>
        <#list accounts as ac>
        <tr>
            <td>${ac.name}</td>
            <td>${ac.owner.username}</td>
            <td>${ac.currency}</td>
            <td>${ac.balance}</td>
            <td>${ac.openingDate?date}</td>
            <td>
                <a href="/accounts/edit/#{ac.id}" class="btn btn-outline-primary" role="button" aria-pressed="true">Edit</a>
            </td>
            <td>
                <a href="/accounts/delete/#{ac.id}" class="btn btn-outline-danger" role="button" aria-pressed="true">Delete</a>
            </td>
        </tr>
        </#list>
    </table>
    <a href="/accounts/add" class="btn btn-outline-primary" role="button" aria-pressed="true">Add new account</a>

<@m.scriptOn/>
</body>
</html>