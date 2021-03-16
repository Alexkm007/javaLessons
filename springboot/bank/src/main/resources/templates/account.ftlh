<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Accounts"/>
<body>
<@menu.fullmenu/>

<div class="form-group mx-sm-3 mb-2">
</div>
<#if addaccount>
<form action="/accounts/add" method="post">
   <#else >
    <form action="/accounts/edit/{{account.id}}" method="post">
</#if>
        <div class="form-group mx-sm-3 mb-2">
            <input type="hidden" name="id" value="#{account.id}">
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="Name">Name:</label>
                    <input type="text" class="form-control <#if nameError??>is-invalid</#if>" id="name" placeholder="name" name="name" value="${account.name}">
                    <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                    </#if>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="InputDate">Date open:</label>
                    <input type="date"  class="form-control <#if dateError??>is-invalid</#if>" id="InputDate" placeholder="Date" name="openingDate"  value="${openingDate?date}">
                    <#if dateError??>
                    <div class="invalid-feedback">
                        ${dateError}
                    </div>
                    </#if>
                </div>
            </div>
            <#if isadmin >
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Currency</label>
                    </div>
                    <select name="currency" class="custom-select mr-sm-2" id="inputGroupSelect">
                        {{#selectedcurrency}}
                        <option {{&selectedcurrency}}</option>
                        {{/selectedcurrency}}
                        {{^selectedcurrency}}
                        <option selected>Choose..</option>
                        {{/selectedcurrency}}
                        {{#currencylist}}
                        <option value={{.}}>{{.}}</option>
                        {{/currencylist}}
                    </select>
                </div>
            </div>
            <#else >
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="InputDate">Currency:</label>
                    <input type="text" readonly class="form-control" id="Inputcurrency" placeholder="Currency" name="currency"  value="{{account.currency}}">
                </div>
            </div>
            </#if>
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Currency</label>
                    </div>
                    <select name="currency" class="custom-select mr-sm-2" id="inputGroupSelect">
                        {{#selectedcurrency}}
                        <option {{&selectedcurrency}}</option>
                        {{/selectedcurrency}}
                        {{^selectedcurrency}}
                        <option selected>Choose..</option>
                        {{/selectedcurrency}}
                        {{#currencylist}}
                        <option value={{.}}>{{.}}</option>
                        {{/currencylist}}
                    </select>
                </div>
            </div>
            {{/addaccount}}

            {{^owner}}
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">User</label>
                    </div>
                    <select name="user" class="custom-select mr-sm-2" id="inputGroupSelect01">

                        {{#selecteduser}}
                        <option selected {{& selecteduser}} </option>
                        {{/selecteduser}}
                        {{^selecteduser}}
                        <option selected value="0">Choose..</option>
                        {{/selecteduser}}
                        {{#userlist}}
                        <option value={{id}}>{{username}}</option>
                        {{/userlist}}
                    </select>
                </div>
            </div>
            {{/owner}}
            {{#owner}}
            <input type="hidden"  name="user"  value="{{owner}}">
            {{/owner}}

            <input type="hidden" name="_csrf" value={{_csrf.token}}>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>


<@m.scriptOn/>
</body>
</html>