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
    <script src="/js/jquery.js"></script>
    <script src="/js/func.js"></script>
    <title>FigureSkateBlog</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <#import "blocks/header.ftl" as header>
    <@header.header />
</nav>


<p class="text-center fs-1 m-4">Видео</p>
<@security.authorize access="isAuthenticated()">
    <@security.authorize access="hasAuthority('ADMIN')">
        <div class="container col-12 special_col mb-4 text-center">>
            <form action="/article/${article.id}/edit">
                <button class="btn btn-primary" type="submit">Редактировать</button>
            </form>
            <form action="/article/${article.id}/delete">
                <button class="btn btn-primary" type="submit">Удалить</button>
            </form>
        </div>
    </@security.authorize>
</@security.authorize>

<div class="container">
    <section class="">
        <div class="row">
            <div class = "mainContent col-12">
                <div class="col special_col p-5 mb-4">

                        <div class="embed-responsive video mb-5">
                            <iframe width="560" height="315" class="embed-responsive-item" src="${article.videoUrl}" allowfullscreen></iframe>
                        </div>
                        <div class="data">
                            <h3>${article.title}</h3>
                            <hr>
                            <div class="content">
                                <p>${article.content}</p>
                            </div>
                            <button class="photos__like-icon" type="button"></button>
                            <div class="photos__like-count">0</div>
                            <br>
                        </div>


                    <section class = "comments">
                        <#--<#import "blocks/new-comment.ftl" as new>
                        <@new.new />-->

                        <div id="comments-list-container">
                            
                        </div>
                        <div class="d-flex justify-content-center m-4" id = "comments-load-more-ctrl">
                            <a type="button" onclick="moreComments()" class="btn btn-block btn-lg text-body special load-more-btn">Загрузить еще</a>
                            <img src="https://acegif.com/wp-content/uploads/loading-97.gif" style="width: 20%" class="loading-indicator" />
                        </div>

                    </section>
                </div>
                <div class="col-lg-4 col-sm-6 navig right category">
                    <div class="card p-4 mb-5">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <@security.authorize access="isAuthenticated()">
                                <@security.authorize access="hasAuthority('ADMIN')">
                                    <div>
                                        <form action="/article/${article.id}/edit">
                                            <button class="btn btn-primary" type="submit">Редактировать</button>
                                        </form>
                                        <form action="/article/${article.id}/delete">
                                            <button class="btn btn-primary" type="submit">Удалить</button>
                                        </form>
                                    </div>
                                </@security.authorize>
                            </@security.authorize>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <input type="text" value="0" id="pageCount" hidden>
    <input type="text" value="${article.id}" id="articleId" hidden>
</div>

<footer class="text-white">
    <#import "blocks/footer.ftl" as footer>
    <@footer.footer />
</footer>
<script>
    function moreComments() {
        var size = 5;
        var page = $('#pageCount').val();
        var articleId = $('#articleId').val();
        $('#comments-load-more-ctrl .load-more-btn').css('display', 'none');
        $('#comments-load-more-ctrl .loading-indicator').css('display', 'block');
        $.ajax({
            url: "/api/v2/articles/" + articleId + "/comments?page=" + page + "&size=" + size,
            dataType: 'json',
            success : function(data) {
                console.log(data)
                $('#comments-load-more-ctrl .loading-indicator').css('display', 'none');
                data['content'].forEach(function (comment) {
                    $('#comments-list-container').append($('<div class="media-object comment-item" data-id-comment="' + comment['id'] + '">' +
                        '            <div class="container text-white mt-3 ">' +
                        '                <div class="card">' +
                        '                    <div class="card-body p-4">' +
                        '                        <div class="comment-change">' +
                        '                                    <h3>"' + comment['user']['email'] + '"</h3>' +
                        '                            <div>' +
                        '                                <div class="media-object-section">' +
                        '                                    <h5 class = "name">' + comment['user']['firstName'] + '</h5>' +
                        '                                    <p>' + comment['text'] + '</p>' +
                        '                                    <p class="meta">' +
                        '                                        <small><fmt:formatDate type="both" value="' + comment['createdAt'] + '" dateStyle="MEDIUM" timeStyle="SHORT"/></small>' +
                        '                                    </p>' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                    </div>' +
                        '                </div>' +
                        '            </div>' +
                        '        </div>'))
                })
                $('#pageCount').val(++page);
                if (data['totalPages'] == page) {
                    $('#comments-load-more-ctrl .load-more-btn').css('display', 'none');
                } else {
                    $('#comments-load-more-ctrl .load-more-btn').css('display', 'block');
                }
            },
            error : function(data) {
                alert(messages.errorAjax);
            }
        });
    }
</script>
</body>



