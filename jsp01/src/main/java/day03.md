#   Day03

---

- DB 연결방법
  - 해당 DB의 JDBC 라이브러리 설치
  - !!중요 || 라이브러리 추가 후 아티팩트에서 lib으로 밀어넣어주기
  - mariaDB 기준
```java 
    public class DBConnection{
	
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3307/[databaseName]";
		String id = "userID";
		String password = "userPassword";
		try {
			Connection connection = DriverManager.getConntection(url, id, password);
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```
 
- MVC V2 버전 예제
  - `FrontController`로 Controller들을 매핑해주고, request의 URI를 받아 각 역할에 맞는 Controller로 보내준다.
  - `Controller`에서는 ViewPath를 설정한 후 DTO로 사용할 Member를 생성한다. 그 후 DAO역할을 할 MemberService의 실제 메서드를 호출해 DTO를 반환한다.
  - `MyView`에서는 `Controller`에서 받은 ViewPath을 사용해 view역할을 할 jsp파일로 결과물을 반환한다.