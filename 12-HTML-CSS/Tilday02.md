# 오늘 배운 내용

## HTML/CSS

HTML과 CSS
1. HTML(Hyper-Text Markup Language)
    - HTML 문서의 구조와 콘텐츠(contents)를 표현
    - HTML 문서는 구화된 문서이며, 정해진 규칙에 따라 작성해야 한다.
    - HTML 태그(tag)로 HTML 요소(elements)를 작성
2. CSS(Cascading Style Sheets)
    - HTML 요소가 브라우저 화면(viewport)에 어떻게 표현되는지 결정
    - 같은 HTML 태그로 작성한 HTML 요소라도 스타일을 어떻게 지정하는 가에 따라 브라우저 화면에 표현되는게 달라진다.

* 우리가 작성한 HTML 과 CSS 는 브라우저가 HTML 문서를 읽고 해석해서 DOM을 생성한다  그리고 DOM 의 내용을 브라우저 화면에 출력을 한다.  
DOM은 HTML 문서를 기반으로 만들어지지만 둘은 별개의 존재이다.

1. 목록과 관련된 HTML 태그
    - 목록: 항목들의 집합
    - 항목: 유형이 같은 녀석들의 집합
    - `<ul>`(unordered list): 순서가 없는 목록
    - `<ol>`(ordered list): 순서가 있는 목록
    - `<li>`(list item): 목록의 항목
    - `<dl>`(definition list): 정의 목록
    - `<dt>`(definition term): 정의 용어
    - `<dd>`(definition description): 정의 설명
* 목록 안에는 다른 컨텐츠가 들어갈수는 없지만 항목들 안에는 다른 컨텐츠가 들어갈수 있다.
- `<ul>` 요소나 `<ol>` 요소에는 `<li>` 요소만 들어갈 수 있다.

2. 표와 관련된 HTML 태그
    - `<table>`: 표를 표현
    - `<thead>`(table header): 표의 제목 행들의 묶음(생략 가능)
    - `<tbody>`(table body): 표의 본문 행들의 묶음(생략 불가)
    - `<tfoot>`(table foot): 표의 푸터 행들의 묶음(생략 가능)
    - `<tr>`(table row): 표의 행(row)을 표현
    - `<th>`(table heading): 표의 제목 셀을 표현
    - `<td>`(table data): 표의 본문 셀을 표현
    * table 요소를 작성할때 주의점
    1. 표는 HTML 문서에서 구조가 가장 복잡한 콘텐츠다 표는 반드시 필요한 경우에만 사용한다.
    2. `<table>` 요소에는 행들의 묶음을 표현하는 `<thead>` 요소, `<tbody>` 요소, `<tfoot>` 요소가 들어간다.

3. HTML 에서 이미지를 표현하는 `<img>` 태그
    - 웹 브라우저 화면에서 이미지(image)를 표시할 수 있고 `<img>` 태그는 시작 태그만 있다
    - 표현하고자 하는 이미지 가 있으면 src 속성에 지정해줘야 하고 이미지 요소에는 src속성과 alt 속성을 반드시 지정해줘야한다.
    - 이미지의 크기는 HTML속성인 width, height 속성으로 설정을 해줄 수 있고, 설정하지 않으면 원본 크기만큼 표현되고, width 혹은 height 둘중 하나만 지정하면 원본크기 비율에 맞게끔 나머지가 설정된다.
    1. `<img>` 요소: 이미지(image)를 표현
    2. src 속성: `<img>` 요소에서 표시할 이미지의 경로(source)를 지정
    3. alt 속성: 대체 텍스트(alternative text)를 지정

4. HTML에서의 입력 양식 태그
    1. `<form>` : 입력 양식
        - action 속성: 입력 데이터를 전달받아 처리할 웹 애플리케이션의 url을 지정 기본값:url
        - method 속성: 입력 데이터를 전달하는 방식을 지정 기본값: get
        - 입력 방식은 get 방식과 post 방식이 있다. get 방식은 url 에 덧붙여서 전달 post는 데이터를 따로 인코딩해서 전달.
    2. `<input>` : 입력 요소
        - 사용자가 데이터를 입력할수 있는 영역을 생성(지정)
        - type 속성을 지정해서 다양한 형태로 사용 하고 name 속성을 지정해줘야한다.
    3. `<select>` : 선택 입력 요소
    4. `<option>` : 선택 입력 요소의 항목
    5. `<optgroup>` : 선택 입력 요소 항목의 그룹
    6. `<textarea>` : 여러 줄을 입력할 수 있는 글 상자
    7. `<button>` : 버튼 입력
    8. `<label>` : 입력 요소의 캡션
    9. `<fieldset>` : 입력 요소의 그룹

5. HTML 특수  기호  
    - HTML 엔티티(entity)
    1. `&amp;` : & ampersand
    2. `&lt;` : < less than
    3. `&gt;` : > greater than
    4. `&nbsp;` : no-break space=non-breaking space
    5. `&copy`; : copyright sign 
    6. `&sect;` : section sign
7. CSS 블록과 스타일 시트
    - CSS 블록(block)과 스타일 시트(style sheets)
        1. CSS 블록은 HTML 요소에 스타일을 지정하는 항목을 말한다.
            - CSS 블록은 선택자로 시작하며, 중괄호(`{}`)로 묶는다.  
        2. 스타일 시트는 CSS 블록들의 집합이다.
            - 스타일 시트는 `<style>` 요소 안에 작성하고 `<style>`요소는 `<head>`요소 안에 작성한다.
            - 별도의 CSS 파일에 시트를 작성하고, `<head>` 요소안에 `<link>`요소로 불러와 적용가능 하다.
        - HTML 의 주석으로는 `<!-- -->` 가 있고, 스타일 시트의 주석으로는 `/* */` 가있다. 
8. CSS 의`<link>` 요소
    - HTML 문서의 외부 리소스의 관계를 명시하는 HTML 요소
    - 스타일 시트를 기반으로
    1. rel 속성 :  HTML 문서와 연결할 외부 리소스의 관계를 지정
    1. href 속성 : 연결할 외부 리소스의 URL을 지정
9. CSS 선택자(Selectors)
    - CSS 블록에 지정한 스타일을 적용항 HTML(elements)를 선택
    - CSS 선택자는 스타일 시트뿐만 아니라 JavaScript 에서도 사용 가능하다.
    * id 속성과 class 속성(Attributes) 
        - 스타일 시트나 JavaScript 프로그램에서 특정 HTML요소(element)를 선택하기 위해, id속성이나 class 속성으로 HTML요소에 식별자를 구분한다.
        - id 속성과 class 속성은 하나씩만 시정할수있다
        - HTML 요소에 같은 HTML 속성을 여러 개 지정하면 첫 번째 속성만 적용된다.
        - id 속성과 class 속성 값에는 작성 하는 규칙이있다.
        - 영문자와 숫자, 하이픈(-), 밑줄 문자(_)를 조합해서 작성할수 있고, 공백 문자(White spaces)나 다른 기호는 사용할수 없고,
        첫 글자는 영문자로 시작해야 한다.
        - 식별자는 대문자와 소문자를 구분한다.
        1. `id 속성`
            - [id속성] 각각 HTML 요소에 개별적인 식별자를 부여하기 위한 속성이다.
            - DOM 에서 하나의 id 속석 값은 단 하나의 HTML 요소에만 적용할수있다. 즉, id 속성값은 DOM에서 유일해야 한다.
        2. `class 속성`
            - 여러 HTML 요소에 같은 식별자를 부여하기 위한 속성
            - 여러 HTML 요소에 같은 class 속성 값을 적용할 수 있따.
            - `<html>, <head>, <base>, <meta>, <param>, <script>, <style>,<title>` 요소 등을 제거왼 모든 요소에 사용할 수 있다.
    * 상대 선택자
        - 앞에 나온 선택자 (A)로 선택된 HTML 요소를 기준으로, 뒤에 나온 선택자로 
          (B)로 나온 HTML 요소를 선택하는 선택자
          선택자 종류  
          1. 후손 선택자(`A B`) : A 선택자로 선택된 요소의 후손요소들 중에서 선택 (`body li`)
          2. 자식 선택자(`A > B`) : A 선택자로 선택된 요소의 자식 요소들 중에서 선택 (`ul > li`)
          3. 인접 형제 선택자(`A + B`) A선택자로 선택된 요소의 바로 다음에 나오는 형제 요소를 선택 (`tbody + ul`)
          4. 일반 형제 선택자(`A ~ B`): A선택자로 선택된 요소의 다음에 나오는 형제 요소들중에서 선택 (`li ~ li `)
    
    * CSS 의 기본 선택자
    1. `*` : 전체 선택자 (예시 `*`)
    2. `tagName` : 태그 선택자 (예시 `h1`)
    3. `#idAttr` : 아이디 선택자 (예시 `#body`)
    4. `.classAttr` : 클래스 선택자 (예시 `.box`)
    5. `seLector seLector` : 후손 선택자 (예시 `body .box`)
    6. `seLector > seLector` : 자식 선택자 (예시 `body > .box`)
