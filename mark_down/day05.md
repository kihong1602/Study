# Day05

- session을 이용해 로그인 유지 기능을 사용할 수 있음.
- 4일차에 사용한 ControllerV3를 이용해 추가로 회원정보 수정 기능 구현함.
  
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>

<div class="form-signin w-100 m-auto">
    <form action="user/user-modified" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="form-floating">
            <input type="text" name="userID" class="form-control" id="userID"
                   placeholder="ID" value="<%=loggedID%>">
            <label for="userID">ID
            </label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="userPW" name="userPW"
                   placeholder="Password">
            <label for="userPW">Password</label>
        </div>
        <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
    </form>
</div>

<%@include file="/layout/footer.jsp" %>
```

회원정보 수정을 위해 ID와 Password를 입력하는 `modify-form.jsp`

```java
package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserInfoModifiedController implements Controller {
	
	UserService userService;
	
	public UserInfoModifiedController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-modified";
		String id = paramMap.get("userID");
		String pw = paramMap.get("userPW");
		
		User user = new User.UserBuilder(id).password(pw).build();
		User userCheck = userService.checkUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userCheck", userCheck);
		
		return modelView;
	}
}
```

`UserInfoMidifiedController`에서 ID와 PW를 확인하고, `ViewName`을 `user-modified.jsp`로 설정

```java
public User checkUser(User user) {
		connectDB();
		String id = user.getId();
		String pw = user.getPassword();
		String name = null;
		int postcode = 0;
		String address = null;
		String addressDetail = null;
		String email = null;
		String tel = null;
		String sql = "SELECT NAME,POSTCODE, ADDRESS,ADDRESS_DETAIL,EMAIL,TEL FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				name = resultSet.getString("NAME");
				postcode = resultSet.getInt("POSTCODE");
				address = resultSet.getString("ADDRESS");
				addressDetail = resultSet.getString("ADDRESS_DETAIL");
				email = resultSet.getString("EMAIL");
				tel = resultSet.getString("TEL");
			}
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User.UserBuilder(id).name(name).postcode(postcode).address(address)
				.addressDetail(addressDetail).email(email).tel(tel).build();
	}
```

입력받은 user 데이터로 sql을 실행한 후, 변경 가능한 회원정보에 대해 `User`객체로 생성해 반환

```jsp
<%@ page import="com.example.jsp02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>
<%
    User modifiedUser = (User) request.getAttribute("userCheck");
    String name = modifiedUser.getName();
    int postcode = modifiedUser.getPostcode();
    String address = modifiedUser.getAddress();
    String addressDetail = modifiedUser.getAddressDetail();
    String email = modifiedUser.getEmail();
    String tel = modifiedUser.getTel();
%>
<div class="container">
    <form action="user-update" method="post" class="" name="member">
        <input type="hidden" name="userID" value="<%=loggedID%>">
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="userName" value="<%=name%>"
                           name="userName" readonly/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="userEmail" name="userEmail"
                           value="<%=email%>"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="userTel" class="form-label">Tel</label>
                    <input type="text" class="form-control" id="userTel" name="userTel"
                           value="<%=tel%>"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="postCode" class="form-label">postCode</label>
                    <input type="text" class="form-control" id="postCode"
                           value="<%=postcode%>"
                           name="postCode"/>
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
                           value="<%=address%>"/>
                </div>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="addressDetail" class="form-label">Detail Address</label>
                    <input type="text" class="form-control" id="addressDetail"
                           value="<%=addressDetail%>" name="addressDetail"/>
                </div>
            </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
            <div class="col-6">
                <button type="submit" class="btn btn-primary" id="btnSubmit">정보 수정</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </div>
        </div>
    </form>
</div>
<script>
  function DaumPostcode() {
    new daum.Postcode({
      oncomplete: function (data) {
        var roadAddr = data.roadAddress; 
        var extraRoadAddr = ''; 

        
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
</script>
<%@include file="/layout/footer.jsp" %>
```

`user-modified.jsp`에서 수정할 값을 입력받은 후, `user-update`로 URI를 매핑해 request를 보냄.

```java
package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserInfoUpdateController implements Controller {
	
	UserService userService;
	
	public UserInfoUpdateController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-update";
		
		String id = paramMap.get("userID");
		String email = paramMap.get("userEmail");
		String tel = paramMap.get("userTel");
		int postcode = Integer.parseInt(paramMap.get("postCode"));
		String address = paramMap.get("address");
		String addressDetail = paramMap.get("addressDetail");
		
		User user = new User.UserBuilder(id).email(email).tel(tel).postcode(postcode)
				.address(address).addressDetail(addressDetail).build();
		User updateUser = userService.InfoUpdate(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("updateUser", updateUser);
		return modelView;
	}
}
```

URI에 맞는 컨트롤러인 `UserInfoUpdateController`로 이동해, 이전과 같이 진행한다.

---

#### 서버의 데이터 흐름

client -> Servlet -> Service ->DataBase
</br>
client <- View <- Model <- Service
</br>
