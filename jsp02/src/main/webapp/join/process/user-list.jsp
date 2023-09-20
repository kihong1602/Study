<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-09-18
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<div class="container">
    <form action="/join/process/admin-remove.jsp" method="post">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">no</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">email</th>
                <th scope="col">postcode</th>
                <th scope="col">address</th>
                <th scope="col">address_detail</th>
                <th scope="col">reg_date</th>
                <th scope="col">삭제</th>
                <th scope="col"><input type="checkbox" id="checkAll"></th>
            </tr>
            </thead>
            <%
                List<User> userList = (List<User>) request.getAttribute("userList");
                String id = null;
                for (User user : userList) {
                    int no = user.getNo();
                    id = user.getId();
                    String name = user.getName();
                    String email = user.getEmail();
                    String postcode = String.valueOf(user.getPostcode());
                    String address = user.getAddress();
                    String addressDetail = user.getAddressDetail();
                    String regDate = user.getRegDate();
            %>
            <tbody class="table-group-divider">
            <tr>
                <th scope="row"><%=no%>
                </th>
                <td><a href="/join/user/user-select?userID=<%=id%>" id="link"><%=id%>
                </a></td>
                <td><%=name%>
                </td>
                <td><%=email%>
                </td>
                <td><%=postcode%>
                </td>
                <td><%=address%>
                </td>
                <td><%=addressDetail%>
                </td>
                <td><%=regDate%>
                </td>
                <td>
                    <button class="btn btn-danger btnDelete" data-no="<%=no%>">삭제
                    </button>
                </td>
                <td><input type="checkbox" class="check" name="check" value="<%=no%>">
                </td>
            </tr>
            </tbody>
            <%}%>
        </table>
        <button class="btn btn-danger" id="btnAll">회원삭제</button>
    </form>
</div>
<script>
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