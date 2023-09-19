<%@ page import="com.example.jsp02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    User user = (User) request.getAttribute("selectUser");
%>
<h4>userNo : <%=user.getNo()%>
</h4>
<hr>
<h4>userID : <%=user.getId()%>
</h4>
<hr>
<h4>userPW : <%=user.getPassword()%>
</h4>
<hr>
<h4>userName : <%=user.getName()%>
</h4>
<hr>
<h4>userPostcode : <%=user.getPostcode()%>
</h4>
<hr>
<h4>userAddress : <%=user.getAddress()%>
</h4>
<hr>
<h4>userAddressDetail : <%=user.getAddressDetail()%>
</h4>
<hr>
<h4>userRegDate : <%=user.getRegDate()%>
</h4>
<hr>
<div class="form-signin w-100 m-auto">
    <button class="btn btn-primary w-100 py-2" onclick="location.href='/join/modify-form.jsp'">Sign
        in
    </button>
</div>
<%@include file="/layout/footer.jsp" %>
