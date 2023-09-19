# Day04

- MVC Controller V3 패턴으로 회원가입, 회원조회, 회원 전체조회, 회원삭제 기능 구현
  
1. FrontController를 구현해 Controller들의 URI를 매핑해줌.
2. Client로 Request가 들어오면 FrontController에서 URI를 확인하고 해당 Controller로 보냄.
3. Controller는 DAO를 생성해 Service로 전달.
4. Service를 수행하고, Model 반환.
5. Controller로 반환된 Model ViewName과 함께 ModelView에 담아 FrontController로 반환
6. FrontController는 반환받은 ModelView에서 ViewName을 뽑아내 View에게 전달. View는 ViewResolver로 ViewPath생성
7. View에서는 전달받은 ModelView에 담겨져있던 Model을 `request.setAttribute`에 담아줌.
8. 그 후 RequestDispatcher에 ViewPath를 설정한 후 forward시켜준다.

---
>추가로 JQuery를 이용해 ID 중복체크 기능 구현

- `IdCheckController`와  `UserService` 내부에 `idCheck()`를 구현하고 ajax로 Frontcontroller에 request를 보내 ID중복체크 진행

```javascript

    $("#btnIDCheck").on("click", function () {
    $.ajax({
      url: "front-controller/user/id-check",
      data: {
        userID: $("#userID").val(),
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
```

  ```java
    public String idCheck(User user) {
        connectDB();
        String id = user.getId();
        int result = 0;
        String sql = "select count(*) AS count from user where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
            result = resultSet.getInt("count");
             }
         resultSet.close();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
    Map<String, Integer> map = new HashMap<>();
    map.put("count", result);
    Gson gson = new Gson();
    String json = gson.toJson(map);
    return json;
        }
```

`idCheck()`에서 출력값을 json형식으로 만들어준 다음 반환. ViewPath는 `/day04/id-check.jsp`로 설정해줌.

```jsp
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("application/json; charset= UTF-8");
    String json = (String) request.getAttribute("count");
    out.println(json);
%>
```

`id-check.jsp`에서는 response를 json타입으로 변경해주고, request로 받은 attribute를 `out.println()`으로 json형식으로 띄운다.</br>
ajax는 응답을 콜백함수를 통해 받으므로, 최상단 코드의 함수를 실행하게 된다.
