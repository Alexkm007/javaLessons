<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Users"/>
<body>
<@menu.fullmenu/>

<#if addtransaction??>
    <form action="/transactions/add" method="post">
    <#else >
    <form action="/transactions/edit/#{transaction.id}" method="post">
</#if>
        <div class="form-group mx-sm-3 mb-2">
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="Number">Id:</label>
                    <input type="text" readonly class="form-control" id="Number" placeholder="name" name="id" value="#{transaction.id}">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="date">Date:</label>
                    <<input type="date"  class="form-control <#if dateError??>is-invalid</#if>" id="InputDate" placeholder="Date" name="date"  value="${transactionDate}">
                    <#if dateError??>
                        <div class="invalid-feedback">
                            ${dateError}
                        </div>
                    </#if>
                </div>
            </div>

            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">From account</label>
                    </div>
                    <select name="fromAccount" class="custom-select mr-sm-2" id="inputGroupSelect01">

                       <#if selectedaccountFrom??>
                        <option selected &{selectedaccountFrom?n} </option>
                        <#else>
                        <option selected value="0">Choose..</option>
                       </#if>
                        <#list accountslistFrom as alist>
                        <option value=#{alist.id}>${alist.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="input-group mb-3">
                <div class="form-row">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">To account</label>
                    </div>
                    <select name="toAccount" class="custom-select mr-sm-2" id="inputGroupSelect01">

                        <#if selectedaccountTo??>
                            <option selected &{selectedaccountTo?n} </option>
                        <#else>
                            <option selected value="0">Choose..</option>
                        </#if>
                        <#list accountslistTo as alist>
                            <option value=#{alist.id}>${alist.name}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="amount">Amount:</label>
                    <input type="text" class="form-control <#if summaError??>is-invalid</#if>" id="amount" placeholder="amount" name="amount" value="#{transaction.amount}">
                    <#if summaError??>
                    <div class="invalid-feedback">
                        ${summaError}
                    </div>
                    </#if>
                </div>
            </div>
            <@m.csrf/>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
<@m.scriptOn/>
</body>
</html>