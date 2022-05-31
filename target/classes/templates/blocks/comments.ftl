<#macro comment>
     <#list comments as comment>
        <div class="media-object comment-item" data-id-comment="${comment.id}">
            <div class="container text-white mt-3 ">
                <div class="card">
                    <div class="card-body p-4">
                        <div class="comment-change">
                            <img
                                    class="rounded-circle shadow-1-strong me-3 avatar"
                                    src="${comment.account.getAvatar()}"
                                    alt="avatar"
                                    width="65"
                                    height="65"
                            />
                            <div>
                                <div class="media-object-section">
                                    <h5 class = "name">${comment.account.login}</h5>
                                    <p>${comment.text }</p>
                                    <p class="meta">
                                        <a class = "blue_items" href="javascript:reply('${comment.account.login}');">Ответить</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#macro>