<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="com.example.jsp02.entity.Board" %>
<%@ page import="com.example.jsp02.service.BoardService" %>
<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-21
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-10">
            <h2>글보기</h2>
            <table class="table">
                <colgroup>
                    <col style="width: 15%">
                    <col style="width: 35%">
                    <col style="width: 15%">
                    <col style="width: 35%">
                </colgroup>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td colspan="3">${requestScope.board.title}
                    </td>
                </tr>
                <tr>
                    <th>글쓴이</th>
                    <td colspan="3">${requestScope.board.name}
                    </td>
                </tr>
                <tr>
                    <th>날짜</th>
                    <td>${requestScope.board.regDate}
                    </td>
                    <th>조회수</th>
                    <td>${requestScope.board.hit}
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3" class="content">${requestScope.board.content}
                    </td>
                </tr>

                </tbody>

            </table>
            <div class="d-flex justify-content-center mt-5">
                <a href="board.jsp" class="btn btn-primary">목록</a>
                <a href="write.jsp" class="btn btn-primary mx-1">글쓰기</a>
                <a href="javascript:reply('${requestScope.board.reGroup}','${requestScope.board.reLevel}','${requestScope.board.reStep}')"
                   class="btn btn-primary mx-1">답글
                    달기</a>

                <c:if test="${sessionScope.loggedID eq requestScope.board.id}">
                    <a href="javascript:modify('${requestScope.board.no}')"
                       class="btn btn-danger mx-1">수정하기</a>
                    <a href="javascript:remove('${requestScope.board.no}')"
                       class="btn btn-danger mx-1">지우기</a>
                </c:if>
            </div>
        </div>
    </div>
    <div class="content">
        <!-- 이전 글과 다음 글을 표시하는 리스트 -->
        <ul class="pagination pagination1">
            <li>
                <c:if test="${requestScope.prevPost != null}">
                    <a href="javascript:view('${requestScope.prevPost.no}')">${requestScope.prevPost.title}</a>
                </c:if>
            </li>
            <li>
                <c:if test="${requestScope.nextPost != null}">
                    <a href="javascript:view('${requestScope.nextPost.no}')">${requestScope.nextPost.title}</a>
                </c:if>
            </li>
        </ul>
    </div>
</div>
<script>
  function view(boardNo) {
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

  function reply(reGroup, reLevel, reStep) {
    let form = document.createElement('form');

    let re_group;
    re_group = document.createElement('input');
    re_group.setAttribute('type', 'hidden');
    re_group.setAttribute('name', 'regroup');
    re_group.setAttribute('value', reGroup);

    let re_level;
    re_level = document.createElement('input');
    re_level.setAttribute('type', 'hidden');
    re_level.setAttribute('name', 'relevel');
    re_level.setAttribute('value', reLevel);

    let re_step;
    re_step = document.createElement('input');
    re_step.setAttribute('type', 'hidden');
    re_step.setAttribute('name', 'restep');
    re_step.setAttribute('value', reStep);

    form.appendChild(re_group);
    form.appendChild(re_level);
    form.appendChild(re_step);
    form.setAttribute('action', '/reply/reply-process');
    form.setAttribute('method', 'POST');
    document.body.appendChild(form);
    form.submit();
  }

  function modify(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/reply/modify');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }

  function remove(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/reply/remove');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }
</script>
<%@include file="/layout/footer.jsp" %>