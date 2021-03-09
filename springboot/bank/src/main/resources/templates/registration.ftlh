<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title=""/>
<body>
<@menu.nomenu/>
<div class="form-group mx-sm-3 mb-2">
    Registration new user:
</div>

<@m.formHeader action="/registration"/>
    <@m.formInputFildValueError for="InputName" inputLabel="User Name:" name="username" type="text" value=user.username!""/>
    <@m.formInputFildValueError for="InputEmail" inputLabel="User email:" name="emai" type="text" value=user.email!""/>
    <@m.formInputFildValueError for="InputPassword" inputLabel="User password:" name="password" type="password" value=user.password!""/>
    <@m.csrf/>
    <@m.formButton buttonLable="Registration"/>
<@m.formFooter/>

<@m.scriptOn/>
</body>
</html>