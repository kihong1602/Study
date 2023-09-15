<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-15
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>회원가입</h2>
<hr>
<form id="createMember" action="/day03/front-controller/join-save" method="post">
    <div><input type="text" name="userID" placeholder="ID" required></div>
    <div><input type="password" name="userPW" placeholder="Password" required></div>
    <div><input type="text" name="userName" placeholder="Name"></div>
    <div><input type="email" name="userEmail"></div>
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
          document.getElementById("createMember").submit();
        }
      });
    </script>
</form>
<br>
<hr>
<br>
<h2>회원검색</h2>
<form id="selectMember" action="/day03/front-controller/join-select" method="post">
    <div><input type="text" name="userID" placeholder="ID" required></div>
    <div><input type="text" name="userName" placeholder="Name"></div>
    <div><input type="email" name="userEmail"></div>
    <input type="submit" value="회원검색">
</form>
<br>
<hr>
<br>
<h2>회원삭제</h2>
<form id="deleteMember" action="/day03/front-controller/join-delete" method="post">
    <div><input type="text" name="userID" placeholder="ID" required></div>
    <div><input type="password" name="userPW" placeholder="Password" required></div>
    <input type="submit" value="회원검색">
</form>
<br>
<hr>
<br>
<h2>모든 회원 조회</h2>
<form id="selectAllMember" action="/day03/front-controller/member-list" method="post">
    <input type="submit" value="모든 회원 조회">
</form>
</body>
</html>