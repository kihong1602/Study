<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    int gugudanNum = Integer.parseInt(request.getParameter("dan"));
    String result = "";
%>
<ui>
    <%
        for (int i = 1; i <= 9; i++) {
            out.println("<li>" + gugudanNum + " x " + i + " = " + gugudanNum * i + "</li>");
        }
    %>
</ui>
</body>
</html>
