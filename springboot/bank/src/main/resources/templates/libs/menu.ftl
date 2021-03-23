<#import "macro.ftl" as m>
<#import "/spring.ftl" as spring/>
<#assign main><@spring.message "label.menu.home"/></#assign>
<#macro nomenu>
    <@m.menuHeader/>
    <@m.menuItems link="main" name=main/>
    <@m.menuFooterNoMenu/>
</#macro>
<#assign home><@spring.message "label.menu.home"/></#assign>
<#assign exchange><@spring.message "label.menu.exchangerate"/></#assign>
<#assign accounts><@spring.message "label.menu.accounts"/></#assign>
<#assign transactions><@spring.message "label.menu.transaction"/></#assign>
<#assign users><@spring.message "label.menu.users"/></#assign>
<#macro fullmenu isAdmin>
    <@m.menuHeader/>
    <@m.menuItems link="main" name = home/>
    <@m.menuItems link="exchange" name = exchange/>
    <@m.menuItems link="accounts" name = accounts/>
    <@m.menuItems link="transactions" name = transactions/>
    <#if isAdmin>
    <@m.menuItems link="users" name = users/>
    </#if>
    <@m.menuFooter/>
</#macro>