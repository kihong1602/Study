<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-13
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form id="Myform" action="join-process.jsp" method="post">
    <div><input type="text" name="userId" placeholder="ID" required></div>
    <div><input type="password" name="userPw" placeholder="Password" required></div>
    <div><input type="text" name="userName" placeholder="Name"></div>
    <div><input type="text" name="userAddress" placeholder="Address"></div>
    <div><input type="text" name="userZipcode" placeholder="Zipcode"></div>
    <div><input type="email" name="userEmail" placeholder="Email"></div>
    <div><input type="tel" name="userTel" placeholder="tel"></div>
    <div><input type="date" name="userBirth"></div>
    <label for="agree"><input type="checkbox" id="agree">개인정보제공에 동의합니다.</label>
    <button id="btn">제출</button>
    <script>
      document.getElementById("btn").addEventListener("click", function () {
        // 체크박스 상태를 확인합니다.
        const checkbox = document.getElementById("agree");
        if (!checkbox.checked) {
          // 체크박스가 체크되지 않았을 때 알림을 표시합니다.
          alert("개인정보제공 동의를 눌러주세요");
          event.preventDefault();
        } else {
          document.getElementById("myForm").submit();
        }
      });
    </script>
</form>
</body>
</html>