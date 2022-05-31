<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${springMacroRequestContext.contextPath}/css/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" data-auto-replace-svg="nest"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <script src="/js/jquery.js"></script>
    <title>FigureSkateBlog</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <#import "blocks/header.ftl" as header>
    <@header.header />
</nav>

<p class="text-center fs-1 m-4">Редактирование профиля</p>
<form method="post" action="/profile/edit">
    <@spring.bind "user" />
    <div class="form-outline">
        <@spring.formInput  "user.firstName" "name='firstName' required class='form-control form-control-lg' placeholder='${firstName}'" />
        <label class="form-label" for="form3Examplev2">Имя</label>
    </div>
    <div class="form-outline">
        <@spring.formInput  "user.lastName" "name='lastName' required class='form-control form-control-lg' placeholder='${lastName}'" />
        <label class="form-label" for="form3Examplev3">Фамилия</label>
    </div>
    <div class="d-flex justify-content-center mb-2">
        <button type="submit" class="btn btn-block btn-lg text-body special">Сохранить изменения</button>
            <a href="/profile" class="btn btn-danger">Отменить редактирование</a>
    </div>
</form>


<footer class="text-white">
    <#import "blocks/footer.ftl" as footer>
    <@footer.footer />
</footer>

</body>