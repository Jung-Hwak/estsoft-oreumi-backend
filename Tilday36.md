# Spring Boot REST API(2026-01-28)

## 1. 유효성 검사 주해 (Bean Validation Annotations)
- DTO 필드에서 데이터의 정합성을 체크하기 위해 사용한다.

| 주해 (Annotation) | 설명                                     | 실제 활용 예시                          |
| --------------- | -------------------------------------- | --------------------------------- |
| @NotBlank       | `null`, 빈 문자열(""), 공백(" ")을 모두 허용하지 않음 | `private String content;` (댓글 내용) |
| @NotNull        | `null` 값만 허용하지 않음 (빈 문자열은 허용될 수 있음)    | `private Long postId;` (게시물 번호)   |
| @NotEmpty       | `null`과 빈 문자열("")을 허용하지 않음 (공백은 허용)    | `List<String> tags;` (목록 검증)      |
| @Size           | 문자열이나 컬렉션의 길이를 제한 (`min`, `max`)       | @Size(min=2, max=10) String name; |
| @Email          | 이메일 주소 형식인지 검증                         | String email;                     |
| `@Min` / `@Max` | 숫자 값의 최소/최대값 지정                        | @Min(1) int count;                |
| @Pattern        | 정규 표현식을 이용한 커스텀 검증                     | 비밀번호 조합 패턴 등                      |

---

## 2. REST API HTTP 메서드 및 상태 코드
- 리소스에 대한 행위(Method)와 그 처리 결과(Status)를 정의한다.

| 분류    | 항목              | 설명                   | SQL    |
| ----- | --------------- | -------------------- | ------ |
| 메서드   | GET             | 리소스 조회 (목록 또는 상세)    | SELECT |
| 메서드   | POST            | 새로운 리소스 생성           | INSERT |
| 메서드   | PUT             | 리소스 전체 수정 (대체)       | UPDATE |
| 메서드   | DELETE          | 리소스 삭제               | DELETE |
| 상태 코드 | 200 (OK)        | 요청이 성공적으로 처리됨        |        |
| 상태 코드 | 400 (Bad)       | 잘못된 요청 (유효성 검사 실패 등) |        |
| 상태 코드 | 404 (Not Found) | 요청한 리소스를 찾을 수 없음     |        |
| 상태 코드 | 500 (Error)     | 서버 내부 오류 발생          |        |

---

## 3. MockMvc 테스트 및 Web API 메서드
- 백엔드 검증과 프론트엔드 통신에서 사용된 주요 기능들

| 라이브러리     | 메서드명           | 역할                                  |
| --------- | -------------- | ----------------------------------- |
| MockMvc   | perform()      | 서버에 가상 요청을 보냄                       |
| MockMvc   | andExpect()    | 예상되는 상태 코드나 데이터를 검증 (jsonPath 등 사용) |
| MockMvc   | andDo(print()) | 요청/응답 전체 로그를 콘솔에 출력                 |
| Fetch API | fetch()        | 비동기 네트워크 통신 (Promise 기반)            |
| Fetch API | then()         | 비동기 요청이 완료된 후 실행될 콜백 정의             |
| JSON      | stringify()    | 자바스크립트 객체를 JSON 문자열로 직렬화 (전송용)      |
| JSON      | parse()        | JSON 문자열을 자바스크립트 객체로 역직렬화           |
| DOM API   | dataset        | HTML 요소의 `data-*` 속성에 접근하여 값 추출     |

---

## 4. Backend: 유효성 검사 및 전역 예외 처리
- 클라이언트의 데이터를 믿지 않고 서버에서 철저히 검증하며, 발생한 에러를 `JSON`으로 변환하여 프론트엔드에 전달하는 것이 핵심
* **제약 조건 설정** 
    ```java
    // CommentDto.java
    @Data
    @AllArgsConstructor
    @Builder
    public class CommentDto {
        private Long id;
        private Long postId;

        @NotBlank(message = "Content is required.") // ← 제약 조건을 설정하는 주해
        private String content;

        @NotBlank(message = "Writer is required.")
        private String writer;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

* **에러 핸들링**
    ```java
    // CommentController.java
    @RestController
    @RequestMapping("/api/posts/{postId}/comments")
    @RequiredArgsConstructor
    public class CommentController {

    // ===== CURD 메서드 부분 (생략) ======

    // Validation API에서 발생하는 MethodArgumentNotValidException 예외를 처리할 핸들러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

--- 

## 5.MockMvc 테스트
- 요청 설정, 검증(결과 확인)
    ```java
    // 요청 설정
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(URI) // 1. POST 요청을 생성
                    .contentType(MediaType.APPLICATION_JSON)                // 2. 보내는 데이터의 형식을 지정
                    .content(json);                                         // 3. 요청 바디에 JOSN 데이터를 주입
    // 검증, 결과 확인
    mockMvc.perform(request)
        .andExpect(status().isOk())                     // 1. 응답 상태 코드가 200(OK)인지 확인
        .andExpect(jsonPath("$.postId").value(POST_ID)) // 2. JSON 데이터 중 postId가 일치하는지 확인
        .andExpect(jsonPath("$.content").exists())      // 3. content 필드가 존재하는지 확인
        .andDo(print());                                // 4. 요청/응답 콘솔에 출력

---

## 6. 비동기 통신과 효율적인 DOM 조작
- `fetch` API를 사용하여 데이터를 주고받고, 사용자 경험(UX)을 고려한 상태 관리를 수행한다.
* **댓글 등록 및 유효성 검사**
    ```javascript
    // read.html
    // 댓글 등록
    let isPosting = false;          // ← 중복 클릭 방지를 위한 상태 변수

    $commentForm.addEventListener('submit', function (event) {
        event.preventDefault();

        if (isPosting) return;

        const writer = this.writer.value;
        const content = this.content.value;

        if (writer.length <= 0 || content.length <= 0) {
            window.alert('You must enter a writer and content.')
            return;
        }

        isPosting = true;
        $commentForm.submit.disabled = true;

        window.fetch(COMMENT_API_URI, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                postId: postId,
                writer: writer,
                content: content,
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP Error: ${response.statusText}`);
                }

                return response.json();
            })
            .then(data => {
                console.log('CREATE:', data);

                $comments.innerHTML += getHTMLCommentElement(data);

                window.alert('You have created a new comment!');

                $commentForm.writer.value = '';
                $commentForm.content.value = '';
                $commentForm.submit.disabled = false;
                isPosting = false;

                location.href += `#comment-${data.id}`;
            })
            .catch(error => {
                console.error(error);
            });
    }); // #commentForm.onsubmit

* **이벤트 위임을 활용한 수정/삭제**
    ```javascript
    // read.html
    $comments.addEventListener('click', function (event) {
                if (!event.target || event.target === this) return;

                // 댓글 삭제
                if (event.target.classList.contains('comment-button-delete')) {
                    const commentId = event.target.dataset.id;
                    if (!commentId) return;

                    if (!window.confirm('Are you sure to delete the comment?')) return;

                    console.log('DELETE: ' + commentId);

                    window.fetch(COMMENT_API_URI + `/${commentId}`, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json',
                        }
                    })
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(`HTTP Error: ${response.statusText}`);
                            }

                            const $thisComment = $comments.querySelector(`#comment-${commentId}`);
                            $comments.removeChild($thisComment);
                        })
                        .catch(error => {
                            console.error(error);
                        });
                } else if (event.target.classList.contains('comment-button-edit')) {
                    const commentId = event.target.dataset.id;
                    if (!commentId) return;

                    console.log('UPDATE: ' + commentId);

                    const $thisComment = $comments.querySelector(`#comment-${commentId}`);
                    const writer = $thisComment.querySelector('.comment-writer').innerHTML;
                    const content = $thisComment.querySelector('.comment-content').innerHTML;
                    // const createdAt = $thisComment.querySelector('.comment-created-at').dataset.value;

                    const commentHTML = $thisComment.innerHTML;

                    $thisComment.innerHTML = `<form id="commentEditForm">

# 7. Test: MockMvc를 활용한 API 검증
- 컨트롤러가 예상한 대로 응답하고, 유효성 검사 실패 시 400 에러를 잘 던지는지 테스트
    ```java
    // CommentControllerTest.java
    @Test
    public void testCreateFail() throws Exception {
        CommentDto commentDto = CommentDto.builder()
                .postId(POST_ID)
                // .content("[TEST] CommentControllerTest#testCreate")
                .writer("JUnit")
                .build();

        String json = objectMapper.writeValueAsString(commentDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        // 유효성 검사 실패로 인해 400번대 에러가 발생하는지 확인
        mockMvc.perform(request)
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }