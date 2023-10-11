<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-06
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<fmt:parseNumber var="pagination" value="${requestScope.pagination}"/>
<%--pagintaion : paging을 표현할 총 개수--%>
<fmt:parseNumber var="currentPage" value="${requestScope.currentPage}"/>
<%--currentPage = 현재 페이지--%>
<c:set var="currentGroupCal" value="${Math.floor((currentPage-1)/5)}"/>
<%--currentGroup : Pagin 버튼 표현 개수--%>
<%--내림처리 해줘야함--%>
<fmt:formatNumber var="currentGroup" maxFractionDigits="0" value="${currentGroupCal}"/>
<c:set var="startPageCal" value="${currentGroup*5+1}"/>
<%--startPage : currentGroup내에서 표현할 시작 페이지--%>
<fmt:formatNumber var="startPage" maxFractionDigits="0" value="${startPageCal}"/>
<c:set var="endPage1" value="${startPage+4}"/>
<%--endPage : currentGroup에서 표현할 마지막 페이지--%>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Title</th>
            <th scope="col">Writer</th>
            <th scope="col">Date</th>
            <th scope="col">Hit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.boardList}" var="board" varStatus="status">
            <tr class="list">
                <th scope="row">${status.index+1}</th>
                <c:choose>
                    <c:when test="${board.available == 0}">
                        <td>삭제된 게시글 입니다.</td>
                        <td>None</td>
                        <td>None</td>
                        <td>None</td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${board.reStep >1}">
                                <td><a href="javascript:listView('${board.no}')"
                                       class="step step${board.reStep}">
                                    <c:forEach begin="1" end="${board.reStep-1}">
                                        <c:out value="[re]"/>
                                    </c:forEach> ${board.title}</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="javascript:listView('${board.no}')">${board.title}</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
                        <td>${board.name}</td>
                        <td>${board.regDate}</td>
                        <td>${board.hit}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
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
                                         href="javascript:page('${startPage-5}')"
                                         aria-label="Previous"> <span
                        aria-hidden="true">&laquo;</span>
                </a></li>
            </c:if>
            <c:forEach var="i" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${i == requestScope.currentPage}">
                        <li class="page-item"><a class="page-link active"
                                                 href="javascript:page('${i}')">${i}
                        </a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="javascript:page('${i}')">${i}
                        </a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${endPage<pagination}">
                <li class="page-item"><a class="page-link"
                                         href="javascript:page('${endPage+1}')"
                                         aria-label="Next"> <span
                        aria-hidden="true">&raquo;</span>
                </a></li>
            </c:if>
        </ul>
    </nav>
    <div class="d-flex justify-content-center mt-3 mb-3">
        <a href="<c:url value="/new/write"/>" class="btn btn-primary">글쓰기</a>
    </div>
</div>
<script>
  function page(page) {

    let currentUrl = window.location.href;
    // 현재 url 받아서
    let newParam = 'page=' + page;
    // 옮겨갈 page 선언
    if (currentUrl.includes("&page")) {
      //이미 url parameter에 page가 있다면
      let index = currentUrl.indexOf("&page");
      //&page의 인덱스를 찾아서
      currentUrl = currentUrl.replace(currentUrl.substring(index), '');
      //기존 parameter의 '&page=?'부분을 지운다.
    }

    let separator = currentUrl.includes("?") ? "&" : "?";
    //parameter가 있는지 확인 후, 없다면 ?, 있다면 &로 구분자를 처리

    let newUrl = currentUrl + separator + newParam;

    window.location.href = newUrl;

  }

  function listView(boardNo) {
    let form = document.createElement('form');
    let obj;

    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', boardNo);

    form.appendChild(obj);
    form.setAttribute('method', 'post');
    form.setAttribute('action', '/new/view');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>
