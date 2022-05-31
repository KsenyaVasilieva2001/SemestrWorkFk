<#macro header>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<div class="container-fluid">
    <div id="brand">
        <img src="/static/images/figure-skatingPNG.png" width="50%" alt="logo">
    </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto  mb-lg-0 nav-pills ">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>

            <@security.authorize access="isAuthenticated()">
                <@security.authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/api/users">Пользователи</a>
                    </li>
                </@security.authorize>
            </@security.authorize>

            <li class="nav-item">
                <a class="nav-link" href="/articles">Видео</a>
            </li>
            <@security.authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/signin">Вход | Регистрация</a>
                </li>
            </@security.authorize>
            <@security.authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Профиль</a>
                </li>
            </@security.authorize>
            <@security.authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выход</a>
                </li>
            </@security.authorize>
            <li class="nav-item">
                <a class="nav-link" href="/about">О нас</a>
            </li>
        </ul>
    </div>
</div>
</#macro>