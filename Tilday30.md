# 스프링 MVC 및 JPA  (2026-01-20)

## 1. 스프링 MVC 구조와 데이터 바인딩

### 1. 스프링 MVC 동작 원리

* **DispatcherServlet (프론트 컨트롤러):** 모든 요청을 가장 먼저 받아 전체 프로세스를 제어함.
* **Handler Mapping (핸들러 매핑):** 요청 URL을 분석하여 처리를 담당할 컨트롤러를 결정함.
* **Handler Adapter (핸들러 어댑터):** 결정된 컨트롤러의 메서드를 실제로 호출하여 실행함.
* **@RequestMapping:** 특정 URL 요청을 처리할 컨트롤러나 메서드를 지정할 때 사용함.

### 2. 데이터 바인딩 (Data Binding)
* **기본 원리:** 클라이언트의 문자열 파라미터를 자바 객체나 변수 타입으로 자동 변환하여 주입함.
* **DTO(Data Transfer Object) 활용:** 여러 데이터를 묶어 처리할 때 가장 효율적이며, 필드명과 파라미터명이 일치해야 함.
* **@RequestParam:** 개별 변수 바인딩에 사용하며, 원시 자료형은 null 대입이 불가하므로 `defaultValue` 설정이 중요함.
* **@ModelAttribute:** DTO 객체를 모델에 자동 추가하여 뷰에서 사용 가능하게 함 (생략 가능).
* **날짜 처리:** `@InitBinder`로 커스텀 규칙을 정의하거나, `@DateTimeFormat`을 사용하여 간단히 형식을 지정함.

---

## 2. 뷰 처리와 REST API

### 1. 데이터 전달 및 응답
* **Model (모델):** 컨트롤러에서 가공한 데이터를 뷰(View)로 전달하기 위해 담는 객체임.
* **뷰 엔진 (View Engine):** 타임리프(Thymeleaf)를 권장하며, JSP 사용 시 별도 의존성 및 설정이 필요함.
* **@ResponseBody:** 메서드 반환 값을 뷰 리졸버로 보내지 않고 응답 본문(Body)으로 직접 전달함.

### 2. JSON 및 REST API
* **JSON (JavaScript Object Notation):** 데이터 송수신을 위한 표준 텍스트 형식임.
* **Jackson 라이브러리:** 객체 반환 시 자동으로 JSON 형식으로 변환해주며, 이는 REST API의 기초가 됨.

---

## 3. 예외 처리 (AOP 활용)

### 1. 전역 예외 처리 (Global Exception Handling)
* **@ControllerAdvice:** AOP 방식을 활용해 모든 컨트롤러의 예외를 한곳에서 가로채어 처리함.
* **@ExceptionHandler:** 특정 예외 발생 시 실행할 로직(페이지 이동, 로그 기록 등)을 정의함.

### 2. 상세 설정
* **404 에러 처리:** `NoHandlerFoundException` 처리를 위해 `add-mappings: false` 설정이 선행되어야 함.
* **@ResponseStatus:** 응답 시 404 등 특정 HTTP 상태 코드를 명시적으로 지정함.

---

## 4. 3계층 구조와 객체의 종류

### 1. 3계층 구조 (3-Tier Architecture)

* **Presentation (표현):** 컨트롤러가 담당하며 사용자 요청 및 응답을 처리함.
* **Business (비즈니스):** 서비스가 담당하며 핵심 업무 로직을 수행함.
* **Persistence (영속):** 레포지토리(JPA/MyBatis)가 담당하며 DB 접근을 처리함.

### 2. 객체의 구분
* **DTO:** 계층 간 데이터 전송용 객체임.
* **VO (Value Object):** 순수하게 데이터를 저장하고 값 자체를 나타내는 객체임.
* **Entity:** DB 테이블과 직접 매핑되는 핵심 객체로, 보안을 위해 반드시 비즈니스 계층에서 DTO로 변환하여 노출해야 함.

---

## 5. 영속성 프레임워크 비교

* **MyBatis (마이바티스):** SQL 중심의 프레임워크로 직접 쿼리를 작성하여 세밀하게 제어함.
* **JPA (Java Persistence API):** ORM 표준으로 자바 객체와 테이블을 매핑함. SQL 작성 없이 객체 중심으로 DB 작업을 자동화함.