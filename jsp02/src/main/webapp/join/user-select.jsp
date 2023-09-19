<%@ page import="com.example.jsp02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp" %>
<%
    User user = (User) request.getAttribute("selectUser");
%>
<h2>userNo : <%=user.getNo()%>
</h2>
<hr>
<h2>userID : <%=user.getId()%>
</h2>
<hr>
<h2>userPW : <%=user.getPassword()%>
</h2>
<hr>
<h2>userName : <%=user.getName()%>
</h2>
<hr>
<h2>userPostcode : <%=user.getPostcode()%>
</h2>
<hr>
<h2>userAddress : <%=user.getAddress()%>
</h2>
<hr>
<h2>userAddressDetail : <%=user.getAddressDetail()%>
</h2>
<hr>
<h2>userRegDate : <%=user.getRegDate()%>
</h2>
<hr>
<%@include file="layout/footer.jsp" %>
