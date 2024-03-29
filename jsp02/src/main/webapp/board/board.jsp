<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/layout/header.jsp" %>
<fmt:parseNumber var="pagination" value="${requestScope.pagination}"/>
<fmt:parseNumber var="currentPage" value="${requestScope.currentPage}"/>
<c:set var="currentGroupCal" value="${Math.floor((currentPage-1)/5)}"/>
<%--내림처리 해줘야함--%>
<fmt:formatNumber var="currentGroup" maxFractionDigits="0" value="${currentGroupCal}"/>
<c:set var="startPageCal" value="${currentGroup*5+1}"/>
<fmt:formatNumber var="startPage" maxFractionDigits="0" value="${startPageCal}"/>
<c:set var="endPage1" value="${startPage+4}"/>
<%--<c:set var="pagaination" value="${requestScope.pagination}"/>--%>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-8">
            <h2>글 목록</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">no</th>
                    <th scope="col">Title</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date</th>
                    <th scope="col">Hit</th>
                </tr>
                </thead>

                <c:forEach items="${requestScope.boardList}" var="board" varStatus="status">
                    <tbody class="table-group-divider">
                    <tr>
                        <th scope="row">${board.no}
                        </th>
                        <td><a href="javascript:listView('${board.no}')">${board.title}
                        </a>
                        </td>
                        <td>${board.name}
                        </td>
                        <td>${board.regDate}
                        </td>
                        <td>${board.hit}
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
            <nav aria-label="Page navigation">
                <c:choose>
                    <c:when test="${endPage1>pagination}">
                        <c:set var="endPage" value="${pagination}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="endPage" value="${endPage1}"/>
                    </c:otherwise>
                </c:choose>
                <ul class="pagination">
                    <c:if test="${currentGroup>0}">
                        <li class="page-item"><a class="page-link"
                                                 href="?page=${startPage-5}"
                                                 aria-label="Previous"> <span
                                aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>
                    <c:forEach var="i" begin="${startPage}" end="${endPage}">
                        <c:choose>
                            <c:when test="${i == requestScope.currentPage}">
                                <li class="page-item"><a class="page-link active"
                                                         href="?page=${i}">${i}
                                </a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link"
                                                         href="?page=${i}">${i}
                                </a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${endPage<pagination}">
                        <li class="page-item"><a class="page-link"
                                                 href="?page=${endPage+1}"
                                                 aria-label="Next"> <span
                                aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                </ul>
            </nav>
            <form action="<c:url value="/board/progress/search"/>" method="post">
                <label>
                    <select name="search">
                        <option value="all">전체</option>
                        <option value="title">제목</option>
                        <option value="name">글쓴이</option>
                        <option value="content">내용</option>
                    </select>
                </label>
                <label>
                    <input type="text" name="searchWord">
                </label>
                <button>검색</button>
            </form>
        </div>
    </div>
</div>
<script>
  function listView(boardNo) {
    let form = document.createElement('form');

    const cookieValue = getCookie('visitedCookie');

    let visited;
    visited = document.createElement('input');
    visited.setAttribute('type', 'hidden');
    visited.setAttribute('name', 'visitedCookie');
    visited.setAttribute('value', cookieValue);

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', boardNo);

    form.appendChild(obj);
    form.appendChild(visited);
    form.setAttribute('method', 'post');
    form.setAttribute('action', '/board/progress/view');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>
