<#macro header title="">
    <html lang="en" >
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>${title}</title>
    </head>
</#macro>

<#macro menuHeader>
    <nav class="navbar navbar-expand-lg navbar-light bg-success">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand" href="/main">
                <img src="/images/1340048.svg" width="50" height="50" alt="">
            </a>
            <div class="collapse navbar-collapse" id="navbarToggler">
                <ul class="navbar-nav mr-auto">
</#macro>

<#macro menuItems link name>
    <li class="nav-item active">
        <a class="nav-link" href="/${link}">${name}<span class="sr-only">(current)</span></a>
    </li>
</#macro>

<#macro menuFooter>
    </ul>
    <form class="form-inline" action="/logout" method="post">
        <input type="hidden" name="_csrf" value=${_csrf.token}>
        <button type="submit" class="btn btn-light">Logout</button>
    </form>
    </div>

    </div>
    </nav>
</#macro>

<#macro menuFooterNoMenu>
    </ul>
    </div>

    </div>
    </nav>
</#macro>

<#macro scriptOn>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</#macro>

<#macro formHeader action method="post">
    </div>
    <form action="${action}" method="${method}">
        <div class="form-group mx-sm-3 mb-2">
</#macro>

<#macro formInputFildNoValue for inputLabel type name >
            <div class="form-row">
                <div class="form-group col-sm-20">
                    <label for="${for}">${inputLabel}</label>
                    <input type="${type}" class="form-control" id="${for}" placeholder="${inputLabel}" name="${name}">
                </div>
            </div>
</#macro>

<#macro formInputFildValueError for inputLabel name type="text" value="">
    <div class="form-row">
        <div class="form-group col-sm-20">
            <label for="${for}">${inputLabel}</label>
            <input type="${type}" class="form-control
                    <#if .vars[name + "Error"]!"" != "">
                            is-invalid
                    </#if>
                   id="${for}" placeholder="${inputLabel}" name="${name}"
                   value="${value}">
            <#if .vars[name + "Error"]!"" != "">
            <div class="invalid-feedback">
                ${.vars[name + "Error"]!""}
            </div>
            </#if>
        </div>
    </div>
</#macro>

<#macro formButton buttonLable>
            <button type="submit" class="btn btn-primary">${buttonLable}</button>
</#macro>
 <#macro formButtonLink href linkLable="">
     <a href="${href}" class="btn btn-primary" role="button" aria-pressed="true">${linkLable}</a>
 </#macro>

<#macro formFooter>
        </div>
    </form>
</#macro>

<#macro csrf>
    <input type="hidden" name="_csrf" value=${_csrf.token}>
</#macro>