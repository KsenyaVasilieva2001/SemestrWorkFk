<#macro new>
<div class="container text-white comment-item media-object new-comment" id ="new-comment-container">
    <div class="card">
        <div class="card-body p-4">

            <div class="comment-change w-100">
                <img
                        class="rounded-circle shadow-1-strong me-3 avatar"
                <c:if test="${auth eq true}">
                    src="${user.avatar}" alt="${user.avatar}"
                </c:if>
                width="65"
                <c:if test="${auth eq null}">
                    src="https://stalker-co.ru/images/no_image.png" alt="anonym"
                </c:if>
                height="65"/>
                <br/>
                <div>
                    <h5>Добавить комментарий</h5>
                    <div class="form-outline">
                        <textarea class="form-control" id="textAreaExample" id="comment-content" name="comment-content"></textarea>
                    </div>
                    <div class="row d-flex justify-content-between mt-3">
                        <c:if test="${auth eq true}">
                            <a type="button" class="btn blue_items shown.bs.modal" id="modal-btn" href="javascript:submitComment();">Отправить<i class="fas fa-long-arrow-alt-right ms-1"></i>
                            </a>
                        </c:if>
                        <c:if test="${auth eq null}">
                            <a type="button" class="btn blue_items shown.bs.modal" id="modal-btn" data-bs-target="#myModal" data-bs-toggle="modal">Отправить<i class="fas fa-long-arrow-alt-right ms-1"></i>
                            </a>
                        </c:if>
                        <a type="button" href="javascript:gpLogout();" class="logout btn blue_items">Выйти из акканута</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" aria-hidden="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Чтобы оставлять комментарии, необходимо войти в аккаунт</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="g-signin2 small-centered columns" style="width:200px;" data-onsuccess="onSignIn"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>