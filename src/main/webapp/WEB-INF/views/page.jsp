<%--
  Created by IntelliJ IDEA.
  User: Unitv
  Date: 2016/9/18
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

</head>
<body>
<nav>

    <ul class="pagination">
        <c:if test="${page.pages > 1 && !page.isFirstPage}">
            <li><a data-url="${page.prePage}">&laquo;</a></li>
        </c:if>
        <c:forEach var="i" begin="1" end="${page.pages}">
            <c:choose>
                <c:when test="${page.pageNum == i}">
                    <li class="active"><span>${i} <span class="sr-only">(current)</span></span></li>
                </c:when>
                <c:otherwise>
                    <li><a data-url="${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${page.pages > 1 && !page.isLastPage}">
            <li><a data-url="${page.nextPage}">&raquo;</a></li>
        </c:if>

    </ul>
</nav>
<script>
    $(function () {
        $(".pagination a").on("click", function () {
            var url = $(this).attr("data-url");
            url = "${pageUrl}" + url;
            if(!isEmpty(url)){
                $(".main-centor").load(url);
            }
        });

    })
</script>
</body>
</html>
