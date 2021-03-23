<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title=""/>
<body>
<@menu.nomenu/>
<div class="form-group mx-sm-3 mb-2">
    <@spring.message "label.registration"/>
</div>

<@m.formHeader action="/registration"/>
     <div class="form-row">
        <div class="form-group col-sm-20">
            <label for="InputName"><@spring.message "label.user.name"/></label>
            <input type="text" class="form-control <#if usernameError??>is-invalid</#if>" id="InputName" placeholder="User name" name="username"
                   value="<#if user.username??>${user.username}</#if>">
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-20">
            <label for="Inputemail"><@spring.message "label.user.email"/></label>
            <input type="email" class="form-control <#if emailError??>is-invalid</#if>" id="Inputemail" placeholder="User email" name="email"
                   value="<#if email??>${email}</#if>">
            <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-20">
            <label for="InputPassword"><@spring.message "label.user.password"/></label>
            <input type="password" class="form-control <#if passwordError??>is-invalid</#if>" id="InputPassword" placeholder="User password" name="password">
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
        </div>
    </div>
    <@m.csrf/>
    <#assign registration><@spring.message "label.button.registration"/></#assign>
    <@m.formButton buttonLable=registration/>
<@m.formFooter/>

<@m.scriptOn/>
</body>
</html>