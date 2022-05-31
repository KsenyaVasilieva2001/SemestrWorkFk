<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" data-auto-replace-svg="nest"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <title>FigureSkateBlog</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <#import "blocks/header.ftl" as header>
    <@header.header />
</nav>

<p class="text-center text-uppercase fs-1 m-4">Видео</p>

<@security.authorize access="isAuthenticated()">
    <@security.authorize access="hasAuthority('ADMIN')">
        <a href="${springMacroRequestContext.contextPath}/articles/add">Добавить видео</a>
    </@security.authorize>
</@security.authorize>
<div class="container">
    <section class="">
        <div class="row">
            <div class = "mainContent col-12">
                <#list articles as article>
                    <div class="col special_col p-5 mb-4">

                        <div class="embed-responsive video mb-5">
                            <iframe width="560" height="315" class="embed-responsive-item" src="${article.videoUrl}" allowfullscreen></iframe>
                        </div>
                        <div class="data">
                            <h3><a href="${springMacroRequestContext.contextPath}/article/${article.id}">${article.title}</a></h3>
                            <hr>
                            <div class="desc">
                                <p>${article.description}</p>
                            </div>
                        </div>

                    </div>

                </#list>

            </div>
        </div>

    </section>
</div>

<footer class="text-white">
    <#import "blocks/footer.ftl" as footer>
    <@footer.footer />
</footer>

</body>
