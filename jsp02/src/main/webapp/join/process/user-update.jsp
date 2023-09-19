<%@ page import="com.example.jsp02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    User user = (User) request.getAttribute("updateUser");
    int temp = user.getPostcode();
    String postcodeStr = String.valueOf(temp);
    String postcode = postcodeStr.replace(
            postcodeStr.substring(postcodeStr.length() / 2), "*****");

%>
<h4>ID : <%=user.getId()%>
</h4>
<hr>
<h4>Name : <%=user.getName()%>
</h4>
<hr>
<h4>Email : <%=user.getEmail()%>
</h4>
<hr>
<h4>Tel : <%=user.getTel()%>
</h4>
<hr>
<h4>Postcode : <%=postcode%>
</h4>
<hr>
<h4>Address : <%=user.getAddress()%>
</h4>
<hr>
<h4>AddressDetail : <%=user.getAddressDetail()%>
</h4>
<hr>
<h4>RegDate : <%=user.getRegDate()%>
</h4>
<hr>
<div class="form-signin w-100 m-auto">
<%@include file="/layout/footer.jsp" %>