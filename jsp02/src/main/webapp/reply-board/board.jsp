<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-06
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
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
    <div class="d-flex justify-content-center mt-3 mb-3">
        <a href="<c:url value="/reply-board/write.jsp"/>" class="btn btn-primary">글쓰기</a>
    </div>
</div>
<script>
  function listView(boardNo) {
    let form = document.createElement('form');
    let obj;

    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', boardNo);

    form.appendChild(obj);
    form.setAttribute('method', 'post');
    form.setAttribute('action', '/reply/view');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>
