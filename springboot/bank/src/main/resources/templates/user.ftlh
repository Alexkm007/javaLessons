<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<#import "/spring.ftl" as spring/>
<@m.header title="Add/edit user"/>

<body>
<@menu.fullmenu isAdmin/>
<@m.scriptOn/>

<#if adduser>
    <form action="/users/add" method="post">
 <#else>
     <form action="/users/edit/#{user.id}" method="post">
 </#if>
    <div class="form-group mx-sm-3 mb-2">
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
                       value="<#if user.email??>${user.email}</#if>">
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
        <#list roles as key, value>
        <div class="form-row">
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="${key}group" placeholder="${key}" name="${key}" ${value} >
                <label class="form-check-label" for="${key}group">${key}</label>
            </div>
        </div>
        </#list>
        <div class="form-row">
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="Activegroup" placeholder="Active" name="active" ${active}>
                <label class="form-check-label" for="Activegroup"><@spring.message "label.user.active"/></label>
            </div>
        </div>
        <@m.csrf/>
        <button type="submit" class="btn btn-primary"><@spring.message "label.user.save"/></button>
    </div>
         <@m.formFooter/>
</body>
</html>