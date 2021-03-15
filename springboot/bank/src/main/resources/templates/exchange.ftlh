<#import "libs/macro.ftl" as m>
<#import "libs/menu.ftl" as menu>
<@m.header title="Exchange history"/>
<body>
<@menu.fullmenu/>
<#if addexchange>
    <form action="/exchange/add" method="post">
    <#else>
        <form action="/exchange/edit/#{exchange.id}" method="post">
            </#if>
            <div class="form-group mx-sm-3 mb-2">
                <div class="form-row">
                    <div class="form-group col-sm-20">
                        <label for="InputDate">Date record:</label>
                        <input type="date"  data-date-format="yyyy-mm-dd" class="form-control <#if dateError??>is-invalid</#if>" id="InputDate" placeholder="Date" name="date" value="${exchange.date?date}">
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
                            <label class="input-group-text" for="inputGroupSelect01">Currency</label>
                        </div>
                        <select name="currency" class="custom-select mr-sm-2" id="inputGroupSelect01">
                            <option selected>Choose...</option>
                            <#list currencylist as clist>
                            <option value="${clist}">${clist}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-sm-20">
                        <label for="InputRate">Rate:</label>
                        <input type="number" min="0.01" step="0.01" class="form-control <#if rateError??>is-invalid</#if>" id="InputRate" placeholder="rate" name="rate" value="#{exchange.rate}">
                        <#if rateError??>
                        <div class="invalid-feedback">
                            ${rateError}
                        </div>
                        </#if>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-sm-20">
                        <label for="InputRatio">Ratio:</label>
                        <input type="number" min="1" step="1" class="form-control <#if ratioError??>is-invalid</#if>" id="InputRatio" placeholder="ratio" name="ratio" value="#{exchange.ratio}">
                        <#if ratioError??>
                        <div class="invalid-feedback">
                            ${ratioError}
                        </div>
                        </#if>
                    </div>
                </div>

                <@m.csrf/>
                <button type="submit" class="btn btn-primary">Save</button>
                <@m.formFooter/>
<@m.scriptOn/>
</body>
</html>
