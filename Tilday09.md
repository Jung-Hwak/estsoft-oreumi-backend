# 오늘 배운 내용

## JavaScript

1. 문서 객체 모델
   - DOM 에서 각각의 객체를 노드라고 부르며 노드에는 HTMl 문서, 요소, 속성, 내부 텍스트, 주석 객체가 있다.
   - 각각의 문서 노드, 요소 노드, 속성 노드, 텍스트 노드, 주석 노드로 표현이 된다.
   - 돔에서 내가 원하는 객체 HTMLElement 객체 중에서 찾는것을 `DOM 탐색`이라고 한다.
   - 사용자들은 DOM의 변화를 바로 확인하게 된다.
2. HTMLElement 객체를 탐색하는 메서드
   1. document.getElementById(id) : id의 속성값을 가지고 탐색
   2. document.getElementByClassName(cLass) : class의 속성값을 가지고 탐색
   3. document.getElementByTagName(tagName) : 태그이름의 속성값을 가지고 탐색
   4. document.getElementByName(name) : name의 속성값을 가지고 탐색
   5. document.getElementBySelector(seLector) : CSS 선택자를 가지고 탐색
   6. document.getElementBySelectorAll(seLector) : CSS 선택자를 가지고 선택
3. HTMLElement 객체
   1. eLement.innerHTML : 요소의 내부 HTML 마크업을 나타냄.
   2. eLement.innerText : 요소의 내부 텍스트를 나타냄 
   3. node.textContent  : 요소의 내부 텍스트를 나타냄
   4. 
4. document 객체의 속성
   1. document.bdoy : DOM의 <body> 요소 (HTMLlement 객체)
   2. document.documentElement : DOM의 <html> 요소 (HTMLlement 객체)
   3. document.forms : DOM에 있는 모든 <form> 요소들의 배열 (HTMLCollection)
   4. document.images : DOM에 있는 모든 image 요소들의 배열 (HTMLCollection)
   5. document.links : DOM에 있는 모든 <a>요소들의  
      1. document의 객체의 메서드
         1. document.createElemnt : 새로운 HTMLElement 객체 생성   
- DOM API
  - 브라우저세거 제공하는 기능이다.
  - JavaScript와 같은 프로그래밍 언어로 DOM에 있는 어떠한 객체들을 읽고 수정할 수 있다.
  - DOM의 내용을 DOM API로 수정or변경할 경우 브라우저의 화면은 변하게되어 사용자들은 그 변화를 바로 알 수 있게된다.
  1. HTML 요소의 스타일 설정
     - script 에서 HTML 요소들에 스타일을 설정해주면 인라인 스타일으로 설정이 된다.
     - HTML 문서에서 style 이라는 Attribute이 HTML 문서의 우선순위가 가장높다.
     - 그렇기에 script 에서 스타일은 설정 해주면 안된다. 
     - `-`으로 연결되는 스타일 속성은 - 을 지우고 뒤에 시작하는 첫 글자가 대문자로 시작한다. 
     - 예시 `hello.style.border-bottom` = x, `hello.style.borderBottom` = o 
1. for-of 구문
   - 배열, 맵, 집합, 문자열 등 반복 가능한 객체의 각 원소를 순회하기 위해 ES6에서 추가된 제어문
   - 반복 가능한 객체에서 원소들을 차례대로 하나씩 추출해서 대입할 수 있다.
2. 문서 객체의 생성과 추가, 제거
   1. HTMLElement 객체의 추가
   - document.createElement(tagName) : tagName으로 새로운 HTMLElement 객체를 생성할수있다.
   - document.createTextNode(text) : text 노드를 만들어 주는 메서드
   - eLement.appendChild(node) : Element 객체의 마지막 자식 노드로 node를 추가 
   1. HTMLElement 객체의 제거
   - eLement.removeChild(child) : HTMLElement 객체의 자식 노드인 child를 제거
   - HTMLElement 객체의 parentNode 속성은 부모노드를 나타낸다.
   1. HTMLElement 객체의 복제
      - eLement.cloneNode(deep) : eLement객체를 복제해서 새로운 HTMLElement 객체를 생성
      - 새로운 객체를 생성한다고 해서 그 객체가 DOM에 추가되는 것 은 아니다.
      - 복제한 녀석을 뷰포트 DOM에 추가하기위해선 appendChild 로 자식요소로 추가해주는 방법이 있다.
3. 메서드 체이닝
   - 메서드를 연달아서 호출하는 프로그래밍 기법(체인 처럼 연결 되어있을 때를 지칭하는말)
   - 메서드 체이닝을 하기위해선 앞에 쓴 메서드의 반환값이 객체 일때 사용가능하다.
   ```
   // var element = document.getElementById('clone');
   // var clone = element.cloneNode(true);
                        ↓
   var clone = document.getElementById('clone').cloneNode(true);
   document.body.appendChild(clone);  ← body요소에 자식 요소 노드로 clone 을 추가해주는 메서드