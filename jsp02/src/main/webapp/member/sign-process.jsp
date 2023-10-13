<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-12
  Time: 오후 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <form action="<c:url value="/new-member/sign"/>" method="post" class="" name="member"
          enctype="multipart/form-data">
        <div class="row d-flex justify-content-center mt-5">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userID" class="form-label">ID</label>
                    <input type="text" class="form-control" id="userID" placeholder="user id"
                           name="id"/>
                    <button type="button" class="btn btn-primary" id="btnIDCheck">ID 중복확인</button>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userPW" class="form-label">password</label>
                    <input type="password" class="form-control" id="userPW"
                           placeholder="user password" name="password"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userPW02" class="form-label">password Confirm</label>
                    <input type="password" class="form-control" id="userPW02"
                           placeholder="user password"/>
                    <div class="invalid-feedback"></div>
                </div>
            </div>
        </div>

        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="userName" placeholder="user name"
                           name="name"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="userEmail" name="email"
                           placeholder="Email"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userTel" class="form-label">Tel</label>
                    <input type="text" class="form-control" id="userTel" name="tel"
                           placeholder="Tel"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="profile" class="form-control">Profile Image</label>
                    <input type="file" class="form-control"
                           id="profile" placeholder="png,jpg" name="profile"
                           accept="image/gif, image/jpeg, image/png, image/jpg"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="postCode" class="form-label">ZipCode</label>
                    <input type="text" class="form-control" id="postCode" placeholder="post code"
                           name="postcode"/>
                    <div>
                        <input type="button" onclick="DaumPostcode()" value="우편번호 찾기"><br>
                    </div>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address"
                           placeholder="address"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="addressDetail" class="form-label">Detail Address</label>
                    <input type="text" class="form-control" id="addressDetail"
                           placeholder="detail address" name="addressDetail"/>
                </div>
            </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
            <div class="col-6">
                <button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </div>
        </div>
    </form>
</div>
<form action="<c:url value="/new-member/list"/>" method="post">
    <div class="mt-5 mb-5 d-flex justify-content-center">
        <div class="col-6">
            <button type="submit" class="btn btn-primary" id="btnSubmit2">모든 회원 조회</button>
        </div>
    </div>
</form>
<script>
  function DaumPostcode() {
    new daum.Postcode({
      oncomplete: function (data) {

        var roadAddr = data.roadAddress; // 도로명 주소 변수
        var extraRoadAddr = ''; // 참고 항목 변수

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.querySelector('#postCode').value = data.zonecode;
        document.querySelector("#address").value = roadAddr;

        // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
        if (roadAddr !== '') {
          document.getElementById("sample4_extraAddress").value = extraRoadAddr;
        } else {
          document.getElementById("sample4_extraAddress").value = '';
        }
      }
    }).open();
  }

  $("btnPostCode").on("click", function () {
    DaumPostcode();
    return false;
  })
  $("#btnSubmit").on("click", function (e) {
    const userID = $("#userID");
    const userPW = $("#userPW");
    const userPW2 = $("#userPW02");
    if (userID.val().trim() === "") {
      alert("id는 필수입력 사항입니다.");
      userID.val("");
      userID.focus();
      return false;
    } else if (userPW.val().trim() === "") {
      alert("password는 필수입력 사항입니다.");
      userPW.val("");
      userPW.focus();
      return false;
    } else if (userPW2.val().trim() === "") {
      alert("password 확인");
      userPW2.val("");
      userPW2.focus();
      return false;
    }
  });
  $("#userPW02").on("keyup", function () {
    const feedback = $(".invalid-feedback");
    if ($("#userPW").val() !== $("#userPW02").val()) {
      feedback.show();
      feedback.text("password가 맞지 않습니다.");
    } else {
      feedback.hide();
      feedback.text("");
    }
  });

  $("#btnIDCheck").on("click", function () {
    $.ajax({
      url: "/new-member/id-check",
      method: "POST",
      data: {
        id: $("#userID").val(),
      },
      success: function (data) {
        console.log(data.count);
        if (data.count > 0) {
          alert("중복 아이디입니다.");
          $("#userID").val("");
        } else {
          const useID = confirm("사용가능한 아이디입니다. 사용하시겠습니까?");
          if (useID) {
            $("userID").attr("readonly", true);
          }
        }
      },
      fail: function (error) {
        console.log(error);
      },
      complete: function (data) {
        console.log("complete");
      }
    })
  })
</script>
<%@include file="/layout/footer.jsp" %>
