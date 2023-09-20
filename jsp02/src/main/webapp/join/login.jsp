<%@ page import="com.example.jsp02.cookie.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-19
  Time: 오전 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/header.jsp" %>
<%
    String isChecked = "";
    String userID = "";
    String connectID = CookieManager.readCookie("saveID", request);
    String checkBox = CookieManager.readCookie("checkBox", request);
    if (checkBox.equals("rememberMe")) {
        isChecked = "checked";
        userID = connectID;
    } else {
        isChecked = "";
    }
%>
<main>
    <div class="form-signin w-100 m-auto">
        <form action="user/user-login" method="post">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
            <div class="form-floating">
                <input type="text" name="userID" class="form-control" id="userID"
                       placeholder="ID" value="<%=userID%>">
                <label for="userID">userID</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="userPW" name="userPW"
                       placeholder="Password">
                <label for="userPW">Password</label>
            </div>

            <div class="form-check text-start my-3">
                <input class="form-check-input" type="checkbox" value="rememberMe"
                       id="flexCheckDefault" name="saveID" <%=isChecked%>>
                <label class="form-check-label" for="flexCheckDefault">
                    Remember me
                </label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
        </form>
    </div>
</main>
<%@include file="../layout/footer.jsp" %>
