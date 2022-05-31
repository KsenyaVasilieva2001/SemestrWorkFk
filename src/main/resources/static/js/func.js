document.addEventListener('click', ({ target: t }) => {
    if (t.classList.contains('photos__like-icon')) {
        const index = [...document.querySelectorAll('.photos__like-icon')].indexOf(t);
        const count = document.querySelectorAll('.photos__like-count')[index];
        count.classList.toggle('active');
        count.innerText -= [ 1, -1 ][+count.classList.contains('active')];
    }
});

var googleProfile = null;
function googleProfileIsNull(){
    if(googleProfile === null){
        return true;
    }
    else return false;
}
function changer() {
    document.getElementById('modal-btn').setAttribute('data-bs-target', '');
    document.getElementById('modal-btn').setAttribute('href', 'javascript:submitCommentGoogle();');
}
function submitCommentGoogle() {
    if (googleProfile == null) {

    }
    else
        document.getElementById('modal-btn').setAttribute('data-bs-target', '');
    var authToken = googleProfile.authToken;
    var idArticle = $('#comments-list-container').attr('data-id-article');
    var content = $('#new-comment-container textarea').val();
    if (content.trim() != '') {
        $('#comment-content').parent().find('.form-error').css('display', 'none');
        $('#new-comment-container textarea').val('');
        $('#new-comment-loading img').css('display', 'block');
        $.ajax({
            url: '${pageContext.request.contextPath}/ajax/comment',
            method: 'post',
            data: {
                idArticle: idArticle,
                authToken: authToken,
                content: content
            },
            success: function (data) {
                $('#new-comment-loading img').css('display', 'none');
                $('#comments-list-container').prepend(data);
            },
            error: function (data) {
                alert(messages.errorAjax);
            }
        });
    } else {
        $('#comment-content').parent().find('.form-error').css('display', 'inline');
        $('#new-comment-container textarea').val('');
    }
}
function submitComment() {
    var idArticle = $('#comments-list-container').attr('data-id-article');
    var content = $('#new-comment-container textarea').val();
    if (content.trim() != '') {
        $('#comment-content').parent().find('.form-error').css('display', 'none');
        $('#new-comment-container textarea').val('');
        $('#new-comment-loading img').css('display', 'block');
        $.ajax({
            url: '${pageContext.request.contextPath}/ajax/comment',
            method: 'post',
            data: {
                idArticle: idArticle,
                content: content
            },
            success: function (data) {
                $('#new-comment-loading img').css('display', 'none');
                $('#comments-list-container').prepend(data);
            },
            error: function (data) {
                alert(messages.errorAjax);
            }
        });
    } else {
        $('#comment-content').parent().find('.form-error').css('display', 'inline');
        $('#new-comment-container textarea').val('');
    }
}
function onSignIn(googleUser) {
    googleProfile = googleUser.getBasicProfile();
    googleProfile.authToken = googleUser.getAuthResponse().id_token;
    $('#sigin-form').modal('hide')
    if (googleProfile.getImageUrl() != null) {
        $('#new-comment-container img').attr('src', googleProfile.getImageUrl());
    }
    $('#new-comment-container img').attr('alt', googleProfile.getName());
    $('#new-comment-container a.logout').css('display', 'block');
}
function signInGoogle(googleUser){
    googleProfile = googleUser.getBasicProfile();
    googleProfile.authToken = googleUser.getAuthResponse().id_token;

};
function gpLogout() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut();
    googleProfile = null;
    $('#new-comment-container a.logout').css('display', 'none');
    $('#new-comment-container img').attr('src', 'https://stalker-co.ru/images/no_image.png');
    $('#new-comment-container img').attr('alt', messages.anonym);
};



