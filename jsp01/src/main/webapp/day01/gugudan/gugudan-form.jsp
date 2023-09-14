<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="gugudan-result.jsp" method="get">
    <%
        for (int i = 2; i <= 9; i++) {
            out.println("<label><input type=\"radio\" name=\"dan\" value=" + i
                    + "><span>" + i + "</span></label><br>");
        }
    %>
    <%--    <label><input type="radio" name="dan" value="3"><span>3</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="4"><span>4</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="5"><span>5</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="6"><span>6</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="7"><span>7</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="8"><span>8</span></label>--%>
    <%--    <label><input type="radio" name="dan" value="9"><span>9</span></label>--%>
    <button>구구단 출력</button>
</form>
</body>
</html>
