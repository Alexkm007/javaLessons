<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title=greeting/>
<body>
<@menu.fullmenu isAdmin/>
<div class="container mt-2">
    <h3><@spring.message "label.greeting"/></h3>
    <li>
        <a href="main?lang=en_US"> <@spring.message "label.lang_en"/></a>
    </li>
    <li>
        <a href="main?lang=ru_RU"> <@spring.message "label.lang_ru"/></a>
    </li>
</div>
<@m.scriptOn/>
</body>
</html>