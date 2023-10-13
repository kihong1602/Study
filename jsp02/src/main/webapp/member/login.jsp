<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-12
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<script>
  window.onload = function () {
    if ('${requestScope.rememberMe}' === 'rememberMe') {
      createCookie('saveID', '${sessionScope.loggedID}');
      createCookie('checkBox', 'rememberMe');
    } else {
      removeCookie('saveID');
      removeCookie('checkBox');
    }
  }
</script>
<%@include file="/layout/footer.jsp" %>
