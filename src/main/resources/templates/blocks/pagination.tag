<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="pagination" required="true" type="ru.kpfu.itis.models.Pagination"%>
<nav aria-label="pages" class="d-flex justify-content-center align-items-center m-3">
<c:if test="${pagination != null}">
    <ul class="pagination text-center pagination-lg" role="navigation" aria-label="Pagination">
        <li class="page-item pagination-previous${pagination.previous ? '' : ' disabled' }">
            <c:choose>
                <c:when test="${pagination.previous}"><a class = "page-link" href="${pagination.previousUrl}" aria-label="Previous">Предыдущая</a></c:when>
                <c:otherwise><span class = "page-link">Предыдущая</span></c:otherwise>
            </c:choose>
        </li>
        <c:forEach var="page" items="${pagination.pages }">
            <c:choose>
                <c:when test="${page.current }"><li class="page-item current page-link">${page.caption }</li></c:when>
                <c:otherwise><li><a class = "page-link" href="${page.url }" aria-label="Page ${page.caption}">${page.caption}</a></li></c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="page-item pagination-next${pagination.next ? '' : ' disabled' }">
            <c:choose>
                <c:when test="${pagination.next}"><a class = "page-link" href="${pagination.nextUrl}" aria-label="Next page">Следующая</a></c:when>
                <c:otherwise><span class = "page-link">Следующая</span></c:otherwise>
            </c:choose>
        </li>
    </ul>
</c:if>
</nav>