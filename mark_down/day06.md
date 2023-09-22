# Day06

### Cookie

- 2일차에 만들었던 `CookieManger` 클래스를 가져와서 로그인시 아이디저장 시스템으로 재사용 하였음.
- 관리자 기능을 추가해 모든 회원 조회를 가능하게 하고, 체크박스로 여러 회원 삭제 기능, 버튼을 눌러 단독회원 삭제기능, id 클릭시 해당 사용자의 정보를 열람하는 기능을 추가하였음.

**모든회원 조회버튼**

```jsp
<form action="user/user-list" method="post">
    <div class="mt-5 mb-5 d-flex justify-content-center">
        <div class="col-6">
            <button type="submit" class="btn btn-primary" id="btnSubmit2">모든 회원 조회</button>
        </div>
    </div>
</form>
```

**회원 조회 `Controller``**

```jsp
package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.List;
import java.util.Map;

public class UserListController implements Controller {
	
	UserService userService;
	
	public UserListController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-list";
		
		List<User> userList = userService.userList();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userList", userList);
		
		return modelView;
	}
}
```
**회원조회 `Service`**
```jsp
public List<User> userList() {
		connectDB();
		List<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER;";
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				String id = resultSet.getString(2);
				String pw = resultSet.getString(3);
				String name = resultSet.getString(4);
				int postCode = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				String email = resultSet.getString(9);
				String tel = resultSet.getString(10);
				
				User user = new User.UserBuilder(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
			closeDB();
			System.out.println("전체조회 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("전체조회 실패");
		}
		
		return userList;
	}
```

---

**회원 삭제를 위한 체크박스**
```jsp
<td>
    <input type="checkbox" class="check" name="check" value="<%=no%>">
</td>
```
**체크확인을 위한 `JavaScript`코드**
```javascript
<script>
  $('#checkAll').on("click", function () {
    if ($("#checkAll").is(":checked")) {
      $(".check").prop("checked", true);
    } else {
      $(".check").prop("checked", false);
    }
  })
</script>
```
**체크박스가 `form`내부에 있으므로 `<form action="/join/process/admin-remove.jsp" method="post">`로 전송된다.**

<br/>

**다중회원 삭제 코드**
```jsp
<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    UserService userService = new UserService();
    List<User> userList = new ArrayList<>();
    
    String[] paramArr = request.getParameterValues("check");
    for (String strNum : paramArr) {
        int no = Integer.parseInt(strNum);
        User user = userService.adminRemove(no);
        userList.add(user);
    }
    request.setAttribute("userList", userList);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/join/user/user-list");
    requestDispatcher.forward(request, response);
%>
```

---

**단일 회원 삭제를 위한 버튼**
```jsp
<td>
    <button class="btn btn-danger btnDelete" data-no="<%=no%>">삭제</button>
</td>
```

**`JQuery`를 이용한 async 회원삭제 코드**
```javascript
<script>
  $('.btnDelete').on("click", function () {

  const $parent = $(this).parent().parent();

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
```

**단일회원 삭제 코드**
```jsp
<%@ page import="com.example.jsp02.service.UserService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/json; charset=utf-8");
    UserService userService = new UserService();
    int userNo = Integer.parseInt(request.getParameter("userNo"));

    int result = userService.adminDelete(userNo);
    Map<String, String> map = new HashMap<>();
    if (result > 0) {
        map.put("isDelete", "success");
    } else {
        map.put("isDelete", "fail");
    }

    Gson gson = new Gson();
    String json = gson.toJson(map);
    out.println(json);
%>
```

<br/>

---

**user-list에서 ID클릭시 해당회원 정보 조회하기**
```jsp
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
```
- `a`태그를 이용해 쿼리파라미터에 id를 대입해준다.

<br/>

**`/user/user-select`로 전송하게 되므로, `UserSelectController`로 넘어가 작업을 수행**

