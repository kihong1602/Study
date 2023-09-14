<%@ page import="com.common.Person" %>
<%--Created by IntelliJ IDEA.
User: kks45
Date: 2023-09-14
Time: 오전 9:14
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>First Page</h1>
<%

    Person person = new Person("김기홍", 25);

    String name = "김기홍";
    int age = 25;
    //pageContext < request < session < <application

    pageContext.setAttribute("name", "pageContext");
    request.setAttribute("name", person);
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");

    out.println("scope=======");

    String pageContextName = String.valueOf(pageContext.getAttribute("name"));
    Person kim = (Person) request.getAttribute("name");
    String kimName = kim.getName();
    String sessionName = String.valueOf(session.getAttribute("name"));
    String applicationName = String.valueOf(application.getAttribute("name"));

    out.println("<hr>");
    out.println(pageContextName);

    out.println("<hr>");
    out.println(kimName);

    out.println("<hr>");
    out.println(sessionName);

    out.println("<hr>");
    out.println(applicationName);

    request.getRequestDispatcher("second.jsp").forward(request, response);
//    response.sendRedirect("third.jsp");

    //response.sendRedirect()를 사용하면 request는 넘어가지못함.
    //request.getRequestDispatcher().forward()를 사용하면 PageContext는 넘어가지못함.
    //pageContext는 한페이지에 저장
%>
</body>
</html>
