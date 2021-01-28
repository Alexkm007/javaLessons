<#import "parts/common.ftlh" as v>
<#import "parts/login.ftlh" as d>
<@v.page>
Add new user
${message!""}
<@d.login "/registration" />
</@v.page>