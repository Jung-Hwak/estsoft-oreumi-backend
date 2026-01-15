# JSP & Servlet MVC 기반 회원 관리 시스템 통합 (2026-01-15)

JSP, 자바 코드(스크립틀릿), EL과 JSTL을 사용하여 유지보수가 쉬운 View를 설계하며, 서블릿 기반의 MVC 패턴을 완성한다.

---

### EL(Expression Language) 도입 및 기초
* **도입**: `<%= %>`와 같은 복잡한 자바 출력문을 `${}` 형태로 간소화하여 가독성을 높임.
* **주요 기능**:
    * `${member.name}`: 객체 내부의 필드값에 직접 접근 (Getter 자동 호출).
    * **Scope 탐색 순서**: `page` → `request` → `session` → `application` 순으로 데이터를 검색.
    * **연산자**: `${empty list}` (리스트의 null/비어있음 체크), `${num1 + num2}` 등 산술/비교 연산.

---

### JSTL(Standard Tag Library) 활용
* **설정**: JSP 상단에 라이브러리 선언 필수.
  ```jsp
  <%@ taglib prefix="c" uri="[http://java.sun.com/jsp/jstl/core](http://java.sun.com/jsp/jstl/core)" %>
  <%@ taglib prefix="fmt" uri="[http://java.sun.com/jsp/jstl/fmt](http://java.sun.com/jsp/jstl/fmt)" %>

---

* **코어 태그 (c:):**
   - <c:if>: 단일 조건 처리.
   - <c:choose>, <c:when>, <c:otherwise>: 다중 조건문 (switch-case 유사).
   - <c:forEach>: 리스트 반복 출력. varStatus 속성으로 루프 상태(count, index) 관리.
   - <c:set>: 변수 선언 및 유효 범위(Scope) 지정.
* **포맷팅 태그 (fmt:):**
   - <fmt:formatDate>: 날짜 데이터를 원하는 형식(yyyy-MM-dd)으로 변환.
   - <fmt:formatNumber>: 숫자 데이터에 콤마나 통화 기호 삽입.

---

### 회원 정보 수정(Update) 기능 구현
* **수정 로직**
    1. 수정 폼 호출: 목록에서 선택한 ID를 서블릿에 전달 → DAO로 데이터 조회 → request에 저장 → JSP로 Forward.
    2. 수정 실행: 사용자가 수정한 데이터를 서블릿이 수집 → DAO.updateMember 실행 → 목록 페이지로 Redirect.

---

### 실무 코드 ###
1. 회원 목록 반복 출력(forEach)
    ```Java
    <c:forEach var="memberVo" items="${memberList}">
        <tr>
            <td>${memberVo.id}</td>
            <td>${memberVo.username}</td>
            <td>${memberVo.name}</td>
            <td>${memberVo.email}</td>
            <td>${memberVo.createdAt}</td>
            <td>
                [<a href="${contextPath}/member/update?username=${memberVo.username}">UPDATE</a>]
                [<a href="${contextPath}/member/delete?id=${memberVo.id}" class="delete">DELETE</a>]
            </td>
        </tr>
    </c:forEach>


2. 회원 정보 수정
    ### 수정 페이지 호출
    ```java
    // MemberController#doGet() 메서드의 switch문
    case "update" -> {
        viewPage = "member-form";

        // 클라이언트에서 전송한 username 확인
        String username = request.getParameter("username");

        // TODO: username 정보가 유효한 값인지, members 테이블에 있는지 확인하고,
        //       그렇지 않으면 적절한 뒷처리를 한다.

        // members 테이블에서 회원 정보를 조회
        MemberVo memberVo = memberDao.getMember(username);

        // JSP에서 사용하도록 회원 정보를 HttpServletRequest 인스턴스에 바인딩
        request.setAttribute("memberVo", memberVo);
    }

3. 수정 실행
    ``````java
    // MemberController#doPost() 메서드의 if문 
    ...} else if (action.equals("update")) {
        // TODO: username 정보가 members 테이블에 있는지 확인한다.
        // TODO: username이나 email처럼 중복되면 안 되는 컬럼은 꼭 확인한다.

        // members 테이블의 레코드를 갱신
        memberDao.updateMember(memberVo);

        // TODO: 테이블에 새로운 레코드가 제대로 갱신됐는지 확인한다.
    }

    // "/step05/member/list"로 URL 재지정
    response.sendRedirect(request.getContextPath() + "/member/list");


4. 삭제 기능
   1. 삭제 메서드(삭제 기능 로직)
        ```java
        // MemberController#doGet() 메서드의 swich문 
            case "delete" -> {
            // 클라이언트에서 전송한 데이터를 참조
            String id =  request.getParameter("id");

            // TODO: id 정보가 유효한 값인지, members 테이블에 있는지 확인하고,
            //       그렇지 않으면 적절한 뒷처리를 한다.

            // members 테이블에서 주어진 id 컬럼으로 회원 정보를 삭제
            memberDao.deleteMember(id);

            // "/step05/member/list"로 URL 재지정하고 doGet 메서드를 종료
            response.sendRedirect(request.getContextPath() + "/member/list");
            return;
            }
    

   2. 자바 스크립트로 한번더 체크
        ``` javaScript
        // member-list.jsp의 JavaScript
            window.addEventListener('load', function () {
                document.querySelectorAll('.delete').forEach(function (element) {
                    element.addEventListener('click', function (event) {
                        if (!window.confirm('Are you sure to delete the member?')) {
                            event.preventDefault();
                            return;
                        }

                        if (!window.confirm('Once deleted, it cannot be recovered. Are you sure to delete the member?')) {
                            event.preventDefault();
                        }
                    });
                })
            });


   3. HTML 삭제 링크
    ``` html 
        <td>
            [<a href="${contextPath}/member/update?username=${memberVo.username}">UPDATE</a>]
            [<a href="${contextPath}/member/delete?id=${memberVo.id}" class="delete">DELETE</a>]
        </td> 

---

* **주의 사항**
1. 라이브러리 누락 주의: JSTL 태그가 일반 텍스트로 보인다면 상단에 @taglib 선언이 있는지 확인하라.
2. MVC 역할 분담: JSP에는 최대한 로직을 넣지 마라. 데이터 가공은 서블릿과 DAO에서 끝내야 한다.
3. ID 유실 방지: 수정이나 삭제 시 hidden 태그로 식별자(ID)가 서버에 제대로 전달되는지 반드시 체크하라.
4. 결과 처리: 데이터 변경(C, U, D) 후에는 반드시 리다이렉트를 사용해 브라우저의 '새로고침'으로 인한 중복 실행을 막아라.