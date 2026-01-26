# Spring Boot 게시판 페이징 및 상태 유지 관리 정리()

JPA의 `Pageable`을 활용한 데이터 조회부터, 사용자가 보는 화면에 맞게 페이지 번호를 계산하는 `Pagination` 로직, 그리고 페이지 이동 시에도 정보를 잃지 않는 `Criteria` DTO 적용법을 배움

---

## 1. 페이징 공통 정보 관리: `Criteria` DTO
* **컨트롤러 매개변수에서 페이지 번호(`page`)와 한 페이지당 개수(`size`)를 묶어서 처리하기 위한 객체**
- 
    ```java
        // Criteria.java 
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class Criteria {
            private int page = 1;  // 사용자에게는 1부터 보여줌
            private int size = 10; // 기본 한 페이지당 10개
        }


## 2. 화면 UI용 페이징 계산: `Pagination`
* **JPA가 제공하는 데이터 정보 외에, 화면 하단에 [이전] 1 2 3 ... 10 [다음]과 같은 UI를 그리기 위한 계산 로직을 담은 클래스**
- JPA의 Page 객체가 제공하는 정보 외에, 실제 화면 하단 UI(시작/끝 번호, 이전/다음 버튼 활성화)를 그리기 위한 데이터를 계산
- 현재 페이지가 속한 '페이지 블록(Viewport)'을 계산하여 사용자에게 직관적인 내비게이션을 제공해준다.
  ```java
    // Pagination.java
    // 화면에 보여줄 페이지의 마지막 번호
        // = ((현재 페이지 번호) / (페이지 번호의 개수)) * (페이지 번호의 개수)
        int endPage = (int)(Math.ceil((double)pageNumber / pagesPerViewport)) * pagesPerViewport;

        // 화면에 보여줄 페이지의 시작 번호
        // = (페이지의 마지막 번호) - (페이지 번호의 개수) + 1
        int startPage = endPage - pagesPerViewport + 1;

        // 화면에 보여줄 페이지의 시작 번호는 0보다 커야 한다.
        if (startPage <= 0) startPage = 1;

## 3. 컨트롤러 로직: 데이터 조회와 UI 연결
* **서비스 계층에서 전달받은 Page<PostDto>와 Pagination 객체를 결합하여 뷰(Thymeleaf)로 전달한다.**
- 동작방식: Criteria를 JPA용 Pageable로 변환하여 데이터를 조회하고, 그 결과를 다시 Pagination으로 가공하여 모델에 담아둔다.
  ```java
    // BoardController.java
    // "/board/"와 "/board/list"로 들어온 GET 방식의 요청에 매핑
        @GetMapping({ "", "/list" })
        public String list(Criteria criteria, Model model) {
            log.info("list = {}", criteria);

            Pageable pageable = PageRequest.of(criteria.getPage() - 1,
                    criteria.getSize(), Sort.by(Sort.Direction.DESC, "id"));

            log.info("pageable = {}", pageable);

            Page<PostDto> postDtoPage = boardService.getList(pageable);

            Pagination pagination = Pagination.of(pageable,
                    postDtoPage.getTotalElements(), postDtoPage.getTotalPages());

            log.info("pagination = {}", pagination);

            model.addAttribute("postDtoList", postDtoPage);
            model.addAttribute("pagination", pagination);

            return "board/list";
        }
* 상세 페이지(read) 이동 시에도 이 객체를 같이 넘겨 목록 복귀 시 원래 보던 페이지 번호를 유지함.

## 4. Thymeleaf 뷰 구현: 정수 반복과 th:block
* **타임리프의 유틸리티와 조건문을 사용하여 유연한 UI를 구현**
- 4-1. #numbers.sequence 메서드와 th:each
  - 동작: #numbers.sequence(start, end)는 시작부터 끝까지의 정수 배열을 생성하고, 이를 th:each와 결합하여 페이징 번호를 동적으로 출력한다.
- 4-2. th:block의 활용
  - 의미: 타임리프의 유일한 논리적 컨테이너 태그로, 렌더링 후 HTML 문서에서 완전히 사라진다.
  - 용도: 반복문의 범위가 특정 HTML 태그(li, div 등)와 일치하지 않거나, 부모 요소에 영향을 주지 않고 로직만 실행하고 싶을 때 사용
  ```html
    <!--list.html-->
    <ol id="pagination" th:object="${pagination}">
        <li th:if="*{startPage} != 1"><a th:href="@{list(page=1)}">First</a></li>
        <li th:if="*{prev}"><a th:href="@{list(page=*{startPage} - 1)}">Prev</a></li>
        <th:block th:each="page : *{#numbers.sequence(startPage, endPage)}">
            <li th:if="${page} == *{pageNumber}"><span th:text="${page}"></span></li>
            <li th:unless="${page} == *{pageNumber}"><a th:href="@{list(page=${page})}" th:text="${page}"></a></li>
        </th:block>
        <li th:if="*{next}"><a th:href="@{list(page=*{endPage} + 1)}">Next</a></li>
        <li th:if="*{endPage} != *{lastPage}"><a th:href="@{list(page=*{lastPage})}">Last</a></li>
    </ol>

## 5.주의사항
1. 0-indexed vs 1-indexed: JPA는 페이지를 0부터 세고, 사용자는 1부터 인식하지만, 컨트롤러에서 -1, Pagination에서 +1 하는 과정에 유의해야 한다.
2. 테스트 코드(MockMvc): testReadWithPaging 메서드처럼 파라미터(id, page)가 모델에 정확히 바인딩되는지 테스트 환경에서 검증하는 습관이 중요하다.
3. 상태 유지: 상세 페이지(read)의 링크 생성 시 page=${pagination.pageNumber}를 함께 전달해야 "목록으로" 버튼이 제 기능을 할 수 있다.