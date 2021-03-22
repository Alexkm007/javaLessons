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

<@m.formHeader action="/login"/>
    <@m.formInputFildNoValue for="InputName" inputLabel="User Name:" type="text" name="username"/>
    <@m.formInputFildNoValue for="InputPassword" inputLabel="Password:" type="password" name="password"/>
    <@m.csrf/>
    <@m.formButton buttonLable="Login"/>
    <@m.formButtonLink href="registration" linkLable="Registration"/>
<@m.formFooter/>

<@m.scriptOn/>
</body>
</html>