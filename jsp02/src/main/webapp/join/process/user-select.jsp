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
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Profile</th>
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
            <th scope="row">${requestScope.selectUser.no}
            </th>
            <td><img
                    src="${pageContext.request.contextPath}/upload/${requestScope.selectUser.profile}"
                    alt="">
            </td>
            <td> ${requestScope.selectUser.id}
            </td>
            <td>${requestScope.selectUser.password}
            </td>
            <td> ${requestScope.selectUser.name}
            </td>
            <td>${requestScope.selectUser.postcode}
            </td>
            <td>${requestScope.selectUser.address}
            </td>
            <td>${requestScope.selectUser.addressDetail}
            </td>
            <td>${requestScope.selectUser.regDate}
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
