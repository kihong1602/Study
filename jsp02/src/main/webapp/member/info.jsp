<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-13
  Time: 오후 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<c:set var="user" value="${requestScope.user}"/>
<div class="info w-100 m-auto">
    <table class="table striped">
        <tbody>
        <tr>
            <th scope="row">Profile Image</th>
            <td><img src="${pageContext.request.contextPath}/upload/${user.profile}" alt=""
                     class="infoImg"></td>
        </tr>
        <tr>
            <th scope="row">ID</th>
            <td>${user.id}
            </td>
        </tr>
        <tr>
            <th scope="row">password</th>
            <td>${user.password}
            </td>
        </tr>
        <tr>
            <th scope="row">name</th>
            <td>${user.name}
            </td>
        </tr>
        <tr>
            <th scope="row">email</th>
            <td>${user.email}
            </td>
        </tr>
        <tr>
            <th scope="row">tel</th>
            <td>${user.tel}
            </td>
        </tr>
        <tr>
            <th scope="row">post code</th>
            <td>${user.postcode}
            </td>
        </tr>
        <tr>
            <th scope="row">address</th>
            <td>${user.address}
            </td>
        </tr>
        <tr>
            <th scope="row">reg date</th>
            <td>${user.regDate}
            </td>
        </tr>
        </tbody>
    </table>

    <div class="d-flex justify-content-center">
        <a href="<c:url value="/new-member/modify-process"/>"
           class="btn btn-primary">정보수정</a>
        <a href="<c:url value="/new-member/withdrawal-process"/>"
           class="btn btn-danger mx-1">회원탈퇴</a>
    </div>
    <%@include file="/layout/footer.jsp" %>
