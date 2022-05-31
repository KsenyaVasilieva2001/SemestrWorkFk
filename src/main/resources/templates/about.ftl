<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
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

<p class="text-center fs-1 m-4">О нас</p>
<div class="container col-12 special_col mb-4">
    <div class = "text-center">Фигурное катание, доступное любому возрасту!</div>
    <p>Клуб основан в 2013г. Клуб “Движение” занимается обучением фигурному катанию всех желающих, независимо от возраста и уровня подготовки. Организует и проводит специальные соревнования для любителей. Имеет как любительские группы, так и спортивные. Член Федерации фигурного катания РТ. Тренеры Клуба - мастера спорта России. Клуб является учредителем и организатором ежегодных Открытых соревнований для спортсменов-любителей "Весенняя капель".
    </p>
    <div class="col-lg-6 col-md-6 mb-4 mb-md-0">
        <h5 class="text-uppercase">Местоположение</h5>

        <ul class="list-unstyled mb-0" style="text-decoration: none;">
            <li>
                <i class="fas fa-map-marked-alt"></i>
                Московская ул., 1, Казань, Россия
            </li>
            <li>
                <i class="fas fa-map-marked-alt"></i>
                Чистопольская ул., 42, Казань, Россия
            </li>
        </ul>
    </div>
    <div class="col-md-4 col-lg-6 col-xl-3  mb-md-0 mb-4">
        <h5 class="text-uppercase">Контакты</h5>
        <p>
            <i class="fas fa-envelope me-3"></i>
            fr_skate@mail.ru
        </p>
        <p><i class="fas fa-phone me-3"></i> +7 (927) 4254411</p>
        <p><i class="fab fa-instagram me-3"></i> motion_club_kzn</p>
    </div>
    <h3 class = "text-center mb-3">ФОТО</h3>
    <div id="carouselIndicators" class="carousel slide mb-4" data-bs-ride="carousel" style="width: 60%; height: 60%;">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="3" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://sun9-86.userapi.com/impg/sd3eQ4WJVxYlxUgXfvg2P6RtE9G5Wo7to8CfoQ/W4AjJwzDCYg.jpg?size=1920x1440&quality=96&sign=2db4f3a44d73d90454ca26c16977fcaa&type=album" class="d-block w-80" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://sun9-28.userapi.com/impg/DeetlfuSWD2uI2f_U6SiIWQX1pl6GUUVpbxrrg/d6XiXusQ8wM.jpg?size=1024x768&quality=96&sign=ef5485cd2260d6b9c9f472ff198ac432&type=album" class="d-block w-80" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://sun9-74.userapi.com/impg/Z573FLHRsZoO5TbMQ1C5awuLobRnDvz64vCwag/gIfmYIgv2TU.jpg?size=1280x958&quality=96&sign=4fb94696bd3ed19599bf0dca11738265&type=album" class="d-block w-80" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://sun9-32.userapi.com/impf/c841039/v841039447/62507/JXZIvSk3mMw.jpg?size=960x720&quality=96&sign=2ff361ed658712cacdc45decd8b5b859&type=album" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>


<footer class="text-white">
    <#import "blocks/footer.ftl" as footer>
    <@footer.footer />
</footer>

</body>