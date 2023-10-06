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
            <tr>
                <th scope="row">${status.index}</th>
                <td><a href="javascript:listView('${board.no}')">${board.title}</a></td>
                <td>${board.name}</td>
                <td>${board.regDate}</td>
                <td>${board.hit}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
