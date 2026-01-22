# CRUD 고도화, Spring MVC, MockMVC (2026-01-22)

## 1. 비즈니스 계층 (Service Layer) 메서드 및 로직 고도화

### 1. 서비스 핵심 메서드 상세 기능
* **findById(id):** 리포지토리에서 ID를 기준으로 데이터를 조회하며 결과는 `Optional`로 반환함.
* **map(PostDTO::from):** 조회된 엔티티가 존재할 경우, 메서드 레퍼런스를 통해 DTO로 즉시 변환함.
* **orElse(null/false):** `Optional`이 비어있을 경우 반환할 기본값(객체 또는 불리언)을 설정함.
* **ifPresent(entity -> ...):** 값이 존재할 때만 특정 로직(수정, 삭제 등)을 수행하도록 제한함.
* **changeTitle(title):** 엔티티 내부에서 상태를 변경하는 메서드로, Setter 대신 의도가 명확한 이름을 사용함.
* **findAll():** DB의 모든 레코드를 조회하여 엔티티 리스트(`List<Entity>`)를 반환함.
* **PostDTO.from(entity):** 엔티티 객체를 전달받아 DTO 객체로 생성 및 변환하는 정적 팩토리 메서드임.

### 2. 함수형 프로그래밍과 선언적 로직
* **표준 함수형 인터페이스:** `Consumer`, `Supplier`, `Function`, `Predicate` 등을 활용하여 비즈니스 로직을 추상화함.
* **Optional 체이닝:** `if-else` 조건문을 지양하고 `map()`, `orElse()` 등을 사용하여 데이터 흐름을 선형적으로 정의함.
* **Update/Delete 로직 고도화:** `findById().map(entity -> { 로직 수행; return true; }).orElse(false)` 패턴을 사용하여 조회와 처리를 한 번에 해결함.
* **DTO 변환 및 캡슐화:** 엔티티가 외부에 노출되지 않도록 DTO로 변환하여 전송하며, 상세 구현을 서비스 계층 내부에 숨김.

---

## 2. 표현 계층 (Controller) 설계 및 Spring MVC

### 1. 컨트롤러 설정 및 주요 메서드
* **@Controller:** 해당 클래스가 Spring MVC의 컨트롤러임을 선언하고 빈(Bean)으로 등록함.
* **@RequiredArgsConstructor:** `final` 필드(BoardService 등)를 초기화하는 생성자를 자동으로 생성하여 의존성을 주입함.
* **@RequestMapping("/board"):** 클래스 상단에 공통 경로를 지정하여 URI 구조를 체계적으로 관리함.
* **@GetMapping({" /list", "/"}):** HTTP GET 요청을 처리하며, 배열을 통해 여러 경로(목록, 메인 등)를 동시 매핑함.
* **@PostMapping("/write"):** 등록이나 수정 등 상태를 변경하는 HTTP POST 요청을 처리함.
* **model.addAttribute("key", value):** 처리한 데이터를 뷰(HTML)로 전달하기 위해 모델 객체에 저장함.
* **"redirect:/board/list":** 작업 완료 후 브라우저가 해당 URL로 다시 요청하도록 재지정(PRG 패턴)함.
* **void 리턴 타입:** 메서드가 `void`를 반환하면 매핑된 URL 경로와 동일한 이름의 뷰 파일을 자동으로 찾음 (예: `/board/list` -> `board/list.html`).

### 2. Spring MVC 구조와 요청 흐름

* **Dispatcher Servlet:** 모든 클라이언트 요청을 중앙에서 제어하는 **Front Controller** 역할을 수행함.
* **핸들러 매핑:** 요청 URL과 HTTP 메서드에 부합하는 컨트롤러 메서드를 찾아 연결해 주는 이정표 역할을 함.
* **PRG(Post-Redirect-Get) 패턴:** POST 처리 후 Redirect를 수행하여 중복 등록 및 새로고침 문제를 원천 차단함.

---

## 3. MockMVC를 이용한 표현 계층 테스트 및 트러블슈팅

### 1. 테스트 환경 및 주요 메서드 체이닝
* **@SpringBootTest & @AutoConfigureMockMvc:** 통합 테스트 환경을 구축하고 MockMVC 인스턴스를 자동으로 주입함.
* **mockMvc.perform(...):** 가상의 HTTP 요청을 실행하는 핵심 메서드임.
* **MockMvcRequestBuilders.get/post(url):** 특정 URL에 대한 가상의 GET/POST 요청 빌더를 생성함.
* **.param("name", "value"):** 요청 시 함께 보낼 쿼리 스트링이나 폼 데이터를 설정함.
* **.andExpect(status().isOk()):** 응답 코드가 200(정상)인지 선언적으로 검증함.
* **.andExpect(model().attributeExists("list")):** 모델에 특정 데이터가 실제로 담겼는지 확인함.
* **.andExpect(view().name("board/list")):** 의도한 뷰 이름이 올바르게 반환되었는지 확인함.
* **.andDo(print()):** 요청/응답의 전체 상세 내역(헤더, 바디, 모델 데이터 등)을 콘솔에 출력하여 디버깅을 지원함.

### 2. 환경 설정 및 트러블슈팅 (build.gradle)
* **발생 원인:** 뷰(HTML) 파일 부재 시 Thymeleaf가 파일을 찾지 못해 `TemplateInputException` 발생함.
* **임시 해결책:** 테스트 중에는 `build.gradle`에서 타임리프 의존성을 **주석 처리**하여 뷰 렌더링 과정을 생략함.
* **의존성 관리:** `implementation` 설정을 수정하고 반드시 **Gradle Refresh(동기화)**를 수행하여 라이브러리 상태를 관리함.
* **버전 특이사항:** 스프링 부트 4(현재 버전)에서는 설정 파일로 타임리프를 끄는 기능이 폐기되어 의존성 제거가 유일한 해결책임.