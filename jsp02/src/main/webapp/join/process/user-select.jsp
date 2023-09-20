<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="java.util.List" %><%--
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

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">no</th>
            <th scope="col">ID</th>
            <th scope="col">Password</th>
            <th scope="col">Name</th>
            <th scope="col">Postcode</th>
            <th scope="col">Address</th>
            <th scope="col">Address_Detail</th>
            <th scope="col">Reg_Date</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <tr>
            <th scope="row"><%=user.getNo()%>
            </th>
            <td><%=user.getId()%>
            </td>
            <td><%=user.getPassword()%>
            </td>
            <td><%=user.getName()%>
            </td>
            <td><%=user.getPostcode()%>
            </td>
            <td><%=user.getAddress()%>
            </td>
            <td><%=user.getAddressDetail()%>
            </td>
            <td><%=user.getRegDate()%>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="form-signin w-100 m-auto">
    <button class="btn btn-primary w-100 py-2" onclick="location.href='/join/modify-form.jsp'">Sign
        in
    </button>
</div>
<%@include file="/layout/footer.jsp" %>
