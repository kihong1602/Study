<%@ page import="com.common.Person" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Second Page</h1>
<h3>하지만 URI는 first.jsp.. </h3>
<hr>
<%
    Person kim = (Person) request.getAttribute("name");
    String kimName = kim.getName();
    out.println(kimName);
    out.println("<br>");
    out.println(session.getAttribute("name"));
    out.println("<br>");
    out.println(application.getAttribute("name"));
%>
</body>
</html>
