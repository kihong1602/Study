# Day02

---

- pageContext : 한페이지에만 유지될 수 있음
- request : `getRequestDispathcer()`사용시에만 다음 URI로 값 전달가능
- session : 서버에 저장되어 URI에 종속되지 않음
- application : 서버 자체 스토리지에 저장되어 URI에 종속되지않음.

> 서버에 저장되어 불러오기가 편한 session과 application이지만, <br/>
> 서버 저장공간을 차지함으로 무분별한 session, application사용은 <br>
> 서버에 과부하를 발생시킨다.<br><br>
> 용도에 따라서 request와 session을 적재적소에 사용해야한다.

<br>

---

<br>

- cookie

  - Key, value값으로 저장됨
  - `setMaxAge()`로 쿠키 유지시간을 설정가능하다. (sec단위)

  <br>
- jquery에서 ajax를 사용해 지정한 url로 request
  - 해당 url에서 `request.getParamet()`로 cookie생성 조건을 확인하고,
  - 조건이 맞다면 Cookie생성
    - `setMaxAge()`,`setPath()`를 사용해 쿠키 유지기간과 보낼 경로 설정
    - `response.addCookie()`로 response에 cookie를 담아서 전송.
  - response 경로의 url에서는 cookie를 `request.getCookie()`를 사용해 cookie배열로 저장.
    - Foreach문으로 cookie 배열을 순회하며 사용처에 맞게 조건을 생성.
