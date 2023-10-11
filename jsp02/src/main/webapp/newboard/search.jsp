<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-11
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<form action="<c:url value="/new/search"/>" method="get">
    <label>
        <select name="category">
            <option value="all">전체</option>
            <option value="title">제목</option>
            <option value="name">글쓴이</option>
            <option value="content">내용</option>
        </select>
    </label>
    <label>
        <input type="text" name="keyWord">
    </label>
    <button>검색</button>
</form>
<%@include file="/layout/footer.jsp" %>