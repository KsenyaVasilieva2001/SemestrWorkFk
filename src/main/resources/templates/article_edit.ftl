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

<div class="d-flex align-items-center wrapper-bg">
    <div class=" reg container mt-5" style=" margin-bottom: 13.5%;">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-12 col-md-6 col-lg-7 col-xl-6">
                <div class="card" style="border-radius: 18px; background: rgba(255, 255, 255, 0.56);">
                    <div class="card-body p-4">
                        <h3 class="text-uppercase text-center mb-3">Редактирование</h3>
                        <@spring.bind "article" />
                        <form action="/article/${article.id}/edit" method="post">
                            <div class="form-outline mb-3">
                                <@spring.formInput  "article.title" "name='title' required class='form-control form-control-lg' placeholder='${title}'" />
                            </div>
                            <div class="form-outline mb-3">
                                <@spring.formInput  "article.description" "name='description' required class='form-control form-control-lg' placeholder='${description}'" />
                            </div>
                            <div class="form-outline mb-3">
                                <@spring.formInput  "article.content" "name='content' required class='form-control form-control-lg' placeholder='${content}'" />
                            </div>
                            <div class="form-outline mb-3">
                                <@spring.formInput  "article.videoUrl" "name='videoUrl' required class='form-control form-control-lg' placeholder='${videoUrl}'" />
                            </div>
                            <div class="d-flex justify-content-center">
                                <input type="submit" class="btn btn-block btn-lg text-body special" value="Сохранить">
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
    </section>
</div>

<footer class="text-white">
    <#import "blocks/footer.ftl" as footer>
    <@footer.footer />
</footer>

</body>
