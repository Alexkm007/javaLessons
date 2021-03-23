<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title=""/>
<body>
<@menu.nomenu/>

<div ${logout}>
    <div class="form-group mx-sm-3 mb-2">
        <@spring.message "label.logout"/>
    </div>
</div>

<#assign name><@spring.message "label.user.name"/></#assign>
<#assign pass><@spring.message "label.user.name"/></#assign>
<#assign login><@spring.message "label.button.login"/></#assign>
<#assign registration><@spring.message "label.button.registration"/></#assign>

<@m.formHeader action="/login"/>
    <@m.formInputFildNoValue for="InputName" inputLabel=name type="text" name="username"/>
    <@m.formInputFildNoValue for="InputPassword" inputLabel=pass type="password" name="password"/>
    <@m.csrf/>
    <@m.formButton buttonLable=login/>
    <@m.formButtonLink href="registration" linkLable=registration/>
<@m.formFooter/>

<@m.scriptOn/>
</body>
</html>