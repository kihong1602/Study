<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <form action="<c:url value="/join/process/admin-remove.jsp"/>" method="post">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">no</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">email</th>
                <th scope="col">tel</th>
                <th scope="col">postcode</th>
                <th scope="col">address</th>
                <th scope="col">address_detail</th>
                <th scope="col">reg_date</th>
                <th scope="col">삭제</th>
                <th scope="col"><label for="checkAll"></label><input type="checkbox" id="checkAll">
                </th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.userList}" var="user" varStatus="status">
                <tbody class="table-group-divider">
                <tr>
                    <th scope="row">${user.no}
                    </th>
                    <td><a href="javascript:info('${user.id}')"
                           id="link">${user.id}
                    </a></td>
                    <td>${user.name}
                    </td>
                    <td>${user.email}
                    </td>
                    <td>${user.tel}
                    </td>
                    <td>${user.postcode}
                    </td>
                    <td>${user.address}
                    </td>
                    <td>${user.addressDetail}
                    </td>
                    <td>${user.regDate}
                    </td>
                    <td>
                        <button class="btn btn-danger btnDelete" data-no="${user.no}">삭제
                        </button>
                    </td>
                    <td><input type="checkbox" class="check" name="check" value="${user.no}">
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
        <button class="btn btn-danger" id="btnAll">회원삭제</button>
    </form>
    <form action="<c:url value="/join/user/user-search"/>" method="post">
        <label for=""></label><select name="searchUser" id="">
        <option value="name">이름</option>
        <option value="id">ID</option>
        <option value="address">주소</option>
        <option value="all">전체</option>
    </select>
        <label>
            <input type="text" name="searchWord">
        </label>
        <button>검색</button>
    </form>

</div>
<script>
  function info(name) {
    const form = document.createElement('form');

    const obj = document.createElement('input');
    obj.setAttribute('name', 'userID');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('value', name);

    form.appendChild(obj);
    form.setAttribute('action', '/join/user/user-select');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }

  $('#checkAll').on("click", function () {
    if ($("#checkAll").is(":checked")) {
      $(".check").prop("checked", true);
    } else {
      $(".check").prop("checked", false);
    }
  })
  $('.btnDelete').on("click", function () {

    const $parent = $(this).parent().parent();
    //this는 tr->td->button이므로, this.parent()는 td, this.parent().parent()는 tr이다.

    $.ajax({
      url: "/join/process/admin-delete.jsp",
      data: {
        userNo: $(this).data("no"),
      },
      success: function (response) {
        console.log(response);
        if (response.isDelete === "success") {
          console.log($(this));
        } else {
          alert("서버오류입니다.")
        }
      },
      fail: function () {

      }
    })
    return false;
  });
</script>
<%@include file="/layout/footer.jsp" %>