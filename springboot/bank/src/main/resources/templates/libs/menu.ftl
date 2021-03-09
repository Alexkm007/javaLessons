<#import "macro.ftl" as m>

<#macro nomenu>
    <@m.menuHeader/>
    <@m.menuItems link="main" name="Main"/>
    <@m.menuFooterNoMenu/>
</#macro>

<#macro fullmenu isAdmin = false>
    <@m.menuHeader/>
    <@m.menuItems link="main" name="Main"/>
    <@m.menuItems link="/exchange" name="Exchange rate"/>
    <@m.menuItems link="/accounts" name="Accounts"/>
    <@m.menuItems link="/transactions" name="Transactions"/>
    <if isAdmin == true>
    <@m.menuItems link="/users" name="Users"/>
    </if>
    <@m.menuFooter/>
</#macro>