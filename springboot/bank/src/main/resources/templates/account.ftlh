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
    <form action="/accounts/edit/#{account.id}" method="post">
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
                    <input type="date"  class="form-control <#if dateError??>is-invalid</#if>" id="InputDate" placeholder="Date" name="openingDate"  value="${openingDate}">
                    <#if dateError??>
                    <div class="invalid-feedback">
                        ${dateError}
                    </div>
                    </#if>
                </div>
            </div>

            <#if !addaccount>
            <#if isadmin >
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Currency</label>
                    </div>
                    <select name="currency" class="custom-select mr-sm-2" id="inputGroupSelect">
                        <#if selectedcurrency??>
                        <option ${selectedcurrency?no_esc}</option>
                            <#else >
                                <option selected>Choose..</option>
                        </#if>
                        <#list currencylist as cl>
                        <option value=${cl}>${cl}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <#else >
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="InputDate">Currency:</label>
                    <input type="text" readonly class="form-control" id="Inputcurrency" placeholder="Currency" name="currency"  value="${account.currency}">
                </div>
            </div>
            </#if>
            <#else >
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Currency</label>
                    </div>
                    <select name="currency" class="custom-select mr-sm-2" id="inputGroupSelect">
                        <#if selectedcurrency??>
                            <option  #{selectedcurrency?no_esc}</option>
                        <#else >
                            <option selected>Choose..</option>
                        </#if>
                        <#list currencylist as cl>
                            <option value=${cl}>${cl}</option>
                        </#list>
                    </select>
                </div>
            </div>
            </#if>

            <#if owner??>
                <input type="hidden"  name="user"  value="${owner}">
            <#else >
                <div class="input-group mb-3">
                    <div class="form-row">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">User</label>
                        </div>
                        <select name="user" class="custom-select mr-sm-2" id="inputGroupSelect01">

                            <#if selecteduser??>
                                <option selected ${selecteduser?no_esc} </option>
                            <#else>
                                <option selected value="0">Choose..</option>
                            </#if>
                            <#list userlist as ul>
                                <option value=#{ul.id}>${ul.username}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </#if>
            <@m.csrf/>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>
<@m.scriptOn/>
</body>
</html>