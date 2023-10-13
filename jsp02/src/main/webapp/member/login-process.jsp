<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-12
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>

<main>
    <div class="form-signin w-100 m-auto">
        <form action="<c:url value="/new-member/login"/>" method="post">
            <h1 class="h3 mb-3 fw-normal">로그인</h1>
            <div class="form-floating">
                <input type="text" name="id" class="form-control" id="userID"
                       placeholder="ID">
                <label for="userID">userID</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="userPW" name="password"
                       placeholder="Password">
                <label for="userPW">Password</label>
            </div>

            <div class="form-check text-start my-3">
                <input class="form-check-input" type="checkbox" value="rememberMe"
                       id="idCheck" name="rememberMe">
                <label class="form-check-label" for="idCheck">
                    Remember me
                </label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
        </form>
    </div>
</main>
<script>
  window.onload = function () {
    const idCookie = getCookie('saveID');
    const checkCookie = getCookie('checkBox');

    if (idCookie != null && checkCookie != null) {
      document.getElementById('userID').value = idCookie;
      const checkBox = document.getElementById('idCheck');
      checkCookie === 'rememberMe' ? checkBox.checked = true : checkBox.checked = false;
    }
  }
</script>
<%@include file="/layout/footer.jsp" %>