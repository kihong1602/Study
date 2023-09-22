********# Day07

### 게시판 만들기

- Entity로 Board class 생성
- 회원관리용 `FrontController`와 경로가 다르므로 게시판 전용 `FrontController`를 새로 생성했음
  - 병합할 방법을 찾게된다면 두 `FrontController` 통합예정
- `session`에 저장한 `loggedID` 또는 `loggedName`을 다시 사용해 해당 유저가 아닐 시 수정 또는 삭제버튼 블라인드 처리함
  
```jsp

            <div class="d-flex justify-content-center mt-5">
                <a href="board.jsp" class="btn btn-primary">목록</a>
                <a href="write.jsp" class="btn btn-primary mx-1">글쓰기</a>
                <%
                    if (loggedID.equals(board.getId())) { %>
                <a href="javascript:modify('<%=board.getNo()%>')"
                   class="btn btn-danger mx-1">수정하기</a>
                <a href="javascript:remove('<%=board.getNo()%>')"
                   class="btn btn-danger mx-1">지우기</a>
                
<script>
  function modify(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/board/process/board-modify.jsp');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }

  function remove(userNo) {
    let form = document.createElement('form');

    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'no');
    obj.setAttribute('value', userNo);

    form.appendChild(obj);
    form.setAttribute('action', '/board/process/board-remove.jsp');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }
</script>
```

- a태그의 하이퍼링크 클릭 시 `JavaScript`로 `form` `input`을 생성해 request를 하도록 구현하였음.

---

- 404, 500 과 같은 Http 상태코드에 대한 page를 설정해 web.xml에 등록
  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
  version="6.0">
 <error-page>
   <error-code>404</error-code>
   <location>/error/error-404.jsp</location>
 </error-page>
 <error-page>
   <error-code>500</error-code>
   <location>/error/error-500.jsp</location>
</error-page>
</web-app>
```
