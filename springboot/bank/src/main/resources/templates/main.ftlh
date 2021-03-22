<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title=greeting/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <h3>${greeting}</h3>
</div>
<@m.scriptOn/>
</body>
</html>