# 오늘 배운 내용

## JavaScript

1. JavaScript의 자료형
    1. 함수
        - 특정한 기능을 하는 코드들을 모아놓은것
        - 개발자들은 반복적으로 쓰이는 코드를 싫어하기에 함수를 미리 만들어서 필요할때마다 써먹을수 있다.
        - 함수를 만드는 것을 함수를 "선언한다" 라고한다
        - 함수는 자료형이 `function`인 프로그램 코드의 집합을 나타내는 값이다.
        - 함수는 `function`으로 선언하고 함수의 식별자를 지정해주고 그 뒤에 괄호()가 나오고 그뒤로 중괄호{}가 나온다.
        - 중괄호 안에는 실행될 코드가 나오고 그것을 함수 본체 라고 한다.
        - 함수를 호출 표현식으로 함수를 호출하면 그에 해당하는 함수가 실행되고 함수의 본체에 있는 코드가 실행된다.
        - 함수 본체의 실행이 끝나면 함수를 호출 했던 표현식으로 다시 되돌아간다.
        - 함수의 선언은 문장이 아니다, 그래서 끝에 세미콜론; 은 붙이지 않는다.
        - 함수는 자료형이 function 값이라서 변수에 대입이 가능하다.
        - 함수를 변수에 대입하여 그 변수의 식별자로도 함수에 접근(호출)이 가능하다.
        ``` 
        function hello () {
            console.log('Hello World!');    ← 함수 선언하기!
        }                               
        hello();                            ← 함수 호출 표현식

        console.log(typeof hello);          // 'function'
        console.log(typeof console.log);    // 'function'
    2. 익명 함수
        - 함수를 선언 하면서 식별자를 지정하지(생략한) 않은 함수 
    3. 함수의 매개 변수
        - 함수를 호출하면 선언되고 인자로 초기화된다.
        - 매개변수는 지역 변수이며 함수안에서만 접근이 가능하다.
       1. 인자
          - 함수를 선언하면 ()안에 인자가 주어진다. 
    4. 지연변수
       - 함수 본체에서 var 키워드로 선언한 변수로 선언한 함수 본체안에서만 접근할수있다.
       - 함수 바깥에서는 접근할 수 없다.  
    5. 함수의 반환 값 
       1. 함수가 정상적으로 종료 되는경우
          - 함수의 본체 끝에 도달했을때
          - 함수 본체의 문장들이 실행되는 도중 return 문을 만났을때
        2. return 문 
           - 실행중인 함수롤 종료하고, 프로그램 실행 흐름은 함수 호출 표현식으로 되돌아간다.
           - 함수에서 return 문으로 실행 결과를 함수 호출 표현식에 반환할 수 있다.
        3. 함수의 반환 값
           - 함수에서 넘겨주는 값을 반환 값이라고하고 함수가 값을 반환 해주는것을 함수가 반환한다 라고 한다.
           - 함수가 반환할 수 있는 값은 한 개 뿐이다.
        ```
        function add(x, y) {
            return x + y;
        }
        var value = add(3, 5);
    6. 함수를 선언할 때 고려할 사항
        - 어떤 기능을 수행할 함수인가, 함수의 매개 변수로는 어떤 것이 필요한가, 어떤 값을 함수의 반환 값으로 넘겨줄 것인가.
        - 계산 하는 함수는 계산만, 출력하는 함수는 출력만 한가지 기능만 하도록 함수를 만들기
2. 지역 변수(Local variables)와 전역 변수(Global variables)
   1. 지역 변수
      - 함수 본체에서 var 키워드로 선언한 변수이다.
      - 선언한 함수 안에서만 접근이 가능하다.
   2. 전역 변수
      - 함수 외부에서 var 키워드로 선언한 변수이다.
      - 프로그램 어디에서든 접근할 수 있다. 

      ```
      var name = 'global';
      function checkScope () {
        var name = 'local';
        console.log(name);
      } 
3. 변수를 선언하는 키워드
   1. var
      - ES5 에서 쓰던 키워드 이다. 
      - 같은 식별자로 여러번 중복해서 선언할 수 있다. 
      - 함수 레벨의 스코프를 가진다.
    * let 과 const는 ES6 에서부터 도입되어온 키워드 이다. 
   2. let 
   3. const
      - let 과 const 키워드로 선언한 변수는 같은 식별자를 중복 선언할 수 없다. var은 가능
      - let 과 const 키워드로 선언한 변수는 블록 레벨 스코프를 가진다.
      - 변수를 선언한 블록 내부에서만 사용이 가능하다.
      - let 키워드로 선언한 변수는 재할당 할수있지만, const 키워드로 선언한 변수는 상수이다, 그러므로 반드시 초기화 해야하고 재할당할 수 없다.
4. JavaScript 의 객체
      - 어떤 대상을 표현하는 여러 값 그리고 그 값들을 기능을 하나로 묶어서 다루 것
      - 값을 저장하는 변수, 객체에 포함되어있는 함수를 다루는 기능을 콘솔 객체 라고한다.
      - 객체가 가지고 있는것은 속성(Property)을 가지고 있고 그 속성에 접근하기위해 키(Key)를 이용한다.
      - 객체의 속성 중에서 자료형이 function(함수)인 속성은 (methods)메서드 라고 한다 
      - 객체는 배열과 달리 객체의 속성들에는 순서가 없다.
      - 객체는 객체 리터럴({})으로 객체를 생성한다.
        ```
                      키(Key)     값          속성(Property)
                        ↓         ↓      (         ↓          )            
        var harry = {firstName: 'Harry', 'lastName': 'Potter'};
        console.log(harry[firstName])        // SyntaxError
        console.log(harry['firstName'])      // harry
        console.log(harry.lastName)         // Potter
        console.log(harry.'lastName')         // SyntaxError
### 브라우저 객체 모델

- Browser Object Model(BOM)
    ```
    브라우저 객체 모델
                    |---------- location (브라우저의 표시줄)
                    |
                    |           navigator (브라우저 정보)
                    |
    window    ------------------- history (브라우저 방문 기록)
    (브라우저)         |
                    |---------- screen (운영 체제 화면 정보)
                    | 
                    |---------- document (DOM - Document Object Model)

1. window 객체
   - window 객체의 타이머 관련 메서드
     - 지정한 시간이 지난 다음, 지정한 기능을 수행하는 타이머
     - 브라우저에 그러한 타이머를 등록한다, 브라우저가 알아서 우리가 지정한 기능을 수행한다.
     - window.setTimeout, window.setInterval 메서드 등이 있다.
     - 등록한 타이머에는 반환 값인 등록한 타이머의 id를 반환해준다.
        ``` 
        타이머 등록하는 방법
        window.setTimeout(function, milliseconds);
            지정한 시간이 지난다음, 지정한 기능을 수행하는 타이머를 브라우저에 등록 
        window.setInterval(function, milliseconds);
            지정한 시간 간격마다, 지정한 기능을 반복적으로 수행하는 타이머를 브라우저에 등록
     - 등록한 타이머를 해제 하는 방법은 crearTimeout, clearInterval 메서드가 있다.
        ```
        window.clearTimeout(인자);
        window.clearInterval(인자);
    - 콜백 함수
      - 함수를 호출하면서 인자로 지정하는 함수를 뜻하는 말      
