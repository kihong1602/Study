<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-14
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String popupMode = "on";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("popupClose")) {
                popupMode = cookie.getValue();
            }
        }
    }
    /*cookie를 request에서 불러오고
     * cookie배열을 순회해서
     * cookie의 name이 popupClose라면
     * popupMode를 해당 cookie의 value로 변경해준다.
     * */
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
      #popup {
        width: 300px;
        height: 300px;
        position: absolute;
        left: 200px;
        top: 200px;
        background: #fff;
        padding: 10px;
        border: 1px solid #ccc;
      }
    </style>
</head>
<script src="../../js/jquery-3.7.1.min.js"></script>
<body>
<%
    if (popupMode.equals("on")) {
%>
<aside id="popup">
    <h2>파업좀 그만해라 노조..</h2>
    <label><input type="checkbox" id="todayCheck" value="1">
        <span>오늘 하루 열지않기</span>
    </label>
    <button id="closeBtn">닫기</button>
</aside>
<%
    }
%>
<script>

  //  jQuery = $

  //$('#closeBtn') == document.querySelector("#closeBtn").add;
  $('#closeBtn').on("click", function () {
    $("#popup").hide();
    // $("#popup").fadeOut(10000); //fade로 사라지게 하는 function

    const isChecked = $("#todayCheck").is(":checked");
    //todayCheck가 checked 상태인지 체크하는 변수
    if (isChecked) {

      //ajax를 사용한 비동기 HTTP request
      $.ajax({url: "popup-cookie.jsp", method: "GET", data: {today: 1}, dataType: "text"});
    }
  });

</script>
</body>
</html>
