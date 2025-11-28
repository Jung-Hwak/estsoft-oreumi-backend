# 오늘 배운 내용


## JavaScript 

1. DOM 이벤트
  - 사용자가 브라우저를 사용하면서 여러 상호 작용이 있고 상호 작용이 있으면 이벤트가 발생한다.
  - 클릭, 스크롤, 드래그, 브라우저 화면의 크기가 변경되는 것, ...등이 있다. 
  - 각 이벤트 마다 이벤트를 구분 하기 위한 이름(식별자)가 있다.
  - 이벤트가 발생하면 브라우저는 객체의 이벤트 속성에 연결되어있는 이벤트 핸들러를 실행한다.
    ```
         이벤트 속성  이벤트 핸들러      
            ↓           ↓
    window.onload = function () {...}; 
  
2. 인라인 이벤트 모델
   - HTML 속성으로 이벤트 속성을 설정하는 형태이다.
   - 속성 값으로 실행할 JavaScript 코드를 지정한다.
3. 고전 이벤트 모델
  - DOM 객체의 이벤트 속성에 이벤트 핸들러를 대입하는 형태이다.
  - 인라인 이벤트 모델에 비해 보다 유연하게 이벤트를 처리할 수 있다.
4. 이벤트 핸드러와 이벤트 연결
  ``` 
  var hello = document.getElementById('hello');

  hello.onclick = function () {
    console.log('Hello World!');
  };

  var elements = document.getElementsByTagName('h2');

  elements[0].onmouseenter = sayHello;    ← 이벤트 핸들러 (선언적 함수)
                    ↑ 이벤트 속성
  function sayHello() {
    console.log('Hello JavaScript!');
  }
5. 이벤트 객체
  - 이벤트와 관련된 정보와 기능을 담고 있는 객체
  - 이벤트가 발생하면 브라우저는 이벤트 객체를 생성하고 이벤트 핸들러의 인자로 지정하고 이벤트 핸들러를 실행시킨다.
6. 기본 이벤트
  - 일부 HTML 요소에 따로 지정하지 않았지만 기본적으로 설정된 기능을 가진것을 '기본 이벤트' 라고 한다.
  - `<a>요소, <input>요소, <form>요소`등이 기본 이벤트를 가지고있다.
  1. 기본 이벤트 제거
    - 기본 이벤트가 동작하지 않도록 기본 이벤트를 제거하는 방법이 있다.
    - 이벤트 핸들러 안에서 `return false;`를 지정하거나, `.preventdefault();` 메서드 등을 호출해서 제거할 수 있다.
  2. 이벤트 전달
    - HTML 요소에서 발생한 몇몇 이벤트는 부모 요소에게 전달이 된다.(click, mousemove, change, submit 이벤트 등등)
    - JavaScript 에서는 '이벤트 버블링' 방식에 따라 이벤트가 전달이 된다.
    - 이벤트 버블링 : 거품이 보글보글 올라가는 것처럼 하위 요소에서 발생한 이벤트가 상위 요소로 전해지는 것
  3. 이벤트 전달 제거
    - 이벤트 핸들러에서 매개 변수를 전달 받고 그 이벤트 객체에  `event.stopPropagation();` 메서드를 호출하는 방법이 있다.
    - 이벤트 전달을 제거하면 그 이벤트 객체는 이벤트 버블링이 생기지 않는다.
    - 이벤트 전달 혹은 기본 이벤트를 제거 하기위해선 이벤트 핸들러 내에서 해야한다.
7. 표준 이벤트 모델
  1. 인라인 이벤트 모델
    - HTML 속성으로 이벤트 속성을 설정하는 형태
  2. 고전 이벤트 모델
    - DOM 객체의 이벤트 속성에 이벤트 핸들러를 대입하는 형태
  3. 표준 이벤트 모델
    - addEventListener
  4. DOM 마우스 이벤트
    - click : 마우스 버튼을 딸깍 하고 클릭 했을 때 발생하는 이벤트
    - mouseenter : 마우스 포인터가 HTL 요소의 경계 외부에서 내부로 이동할 때 발생
    - mouseleave : 마우스 포인터가 HTL 요소의 경계 내부에서 외부로 이동할 때 발생
    1. mouseEvent 객체의 속성
      - button : 마우스 이벤트 발생시 눌러진 마우스 버튼(number; 0 , 1, 2, 3, 4)
      - clientX, clientYL : 현재 창을 기준으로 한 마우스 포인터의 위치
      - pageX, pageY : HTMl 문서를 기준으로 한 마우스 포인터의 위치
  5. DOM 키보드 이벤트
    - keydown : 키보드가 눌러질 때 발생
    - keypress : 글자가 입력될 때 발생
    - keyup : 키보드의 키가 떼어질 때 발생
    1. keyboardEvent 객체의 속성
    - altKey, ctrlKeyl : ALT, CTRL 키 입력 여부
    - metaKey, shifKey : META SHIFT 키 입력 여부
    - code : 이벤크가 일어난 물리 적인 키
    - key : 이벤트가 일어난 키
8. 윈도우 이벤트
  - load : 객체를 불러오는 것이 완료 되었을 때 발상
  - resize : 크기가 변할 때 발생
  - scroll : 윈도우 브라우저의 스크롤 바가 스크롤 될 때 발생

9. DOM 입력 양식 이벤트
  - change : <input>, <select>, <textarea> 요소의 값이 변할 때 발생
  - submit : <form>
