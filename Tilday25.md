# Java JDBC & MVC Architecture (2026-01-12)

## 1. JDBC 환경 구축 및 연동
- **개념**: 자바 애플리케이션과 데이터베이스를 연결하는 표준 인터페이스 **JDBC(Java Database Connectivity)** 학습.
- **ojdbc.jar**: 오라클 제조사가 제공하는 드라이버 라이브러리를 프로젝트 **Build Path**에 등록해야 정상적인 통신 가능.
- **연결 프로세스**: `Class.forName()`으로 드라이버 로드 -> `DriverManager.getConnection(url, id, pw)`를 통해 DB 세션 확보.

---

## 2. PreparedStatement와 동적 쿼리
- **안정성**: 문자열 더하기 방식 대신 **위치 홀더(`?`)**를 사용하여 **SQL Injection** 공격 방어 및 데이터 타입 자동 처리.
- **메서드 구분**:
  - `executeQuery()`: SELECT 문 실행, 결과셋(`ResultSet`) 반환.
  - `executeUpdate()`: INSERT/UPDATE/DELETE 실행, 영향받은 행의 수(`int`) 반환.
- **주의**: 파라미터 바인딩 인덱스는 **1번**부터 시작.

---

## 3. DTO(Data Transfer Object) 패턴
- **캡슐화**: DB 테이블의 한 행(Row) 정보를 자바 객체로 변환하여 관리.
- **구조**: 필드(private), 기본 생성자, **Getter/Setter** 메서드로 구성.
- **용도**: 계층 간 데이터 전달 시 '데이터 바구니' 역할을 수행하여 코드의 가독성 및 유지보수성 향상.

---

## 4. DAO(Data Access Object) 패턴
- **로직 분리**: 실제 DB에 접근하여 SQL을 실행하는 코드만 전담하는 클래스 설계.
- **관심사 분리**: 비즈니스 로직(Main)과 데이터 접근 로직(DAO)을 분리하여 시스템 결합도를 낮춤.
- **모듈화**: 가입, 조회, 수정 등의 기능을 독립된 메서드로 구현하여 재사용성 확보.

---

## 5. 회원 관리 시스템 통합 및 자원 해제
- **Collection 활용**: `ArrayList<MemberDTO>`를 사용하여 다건의 데이터 조회 결과를 효율적으로 핸들링.
- **예외 처리**: **Try-Catch-Finally** 구조를 통해 런타임 에러 대응.
- **자원 반납(Close)**: 메모리 누수 방지를 위해 사용한 `rs`, `pstmt`, `conn` 객체를 **역순(Last In First Out)**으로 반드시 해제.

---

## 6. 전체 흐름 복습 및 리팩토링
- **데이터 사이클**: `Main(UI) ↔ DTO(Data) ↔ DAO(Logic) ↔ DB`의 전체 흐름 완성.
- **로그인 로직**: `rs.next()`의 불리언 값을 활용해 데이터 존재 여부를 확인하고 인증 로직 구현.
- **리팩토링**: 공통 연결 로직을 `getConn()` 메서드로 분리하여 코드 중복 제거 및 응집도 강화.