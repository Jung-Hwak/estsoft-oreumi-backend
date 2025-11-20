# 오늘 배운 내용

## 웹 페이지 레이아웃

1. 모바일 웹 레이아웃(Mobile Web Layout)
    - 주의 할점
        1. 스크롤 바가 존재 하지 않음(스크롤과 관련된 속성을 사용 불가)
        2. 마우스를 사용하는게 아닌 손가락 터치로 해서 상태 선택자 사용의 한계가 있음(:hover, :active)
        3. 브라우저에 따라 지원하지 않는 스타일 속성이 있음
        4. HTMl 요소의 크기를 고정 크기가 아닌 가변 크기(비율)로 만들어야 한다.
        5. 다양한 해상도를 지원할 수 있어야 한다.

* viewport 메타 요소
    - `<meta>` 요소
        - HTML 문서의 메타데이터를 제공하기 위한 HTML 요소
        - `<head>` 요소 안에 작성 해야한다.
    - viewport 메타 요소
        - 브라우저 화면 설정과 관련된 정보를 제공한다.
        - 모바일 웹 페이지의 브라우저 화면의 너비를 기기의 화면 너비로 설정하는 viewport 메타 요소를 반드시 추가해줘야 한다.
        - 추가 해줘야 하는 뷰포트 메타(`content="width=device-width` 필수!)

    ```
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

1. 가변 폭 레이아웃(Fluid Layout)

## transition, animation 스타일 속성

* HTML 문서에 움직임을 줄 수 있는 속성이다.
    - 영향을 받는 스타일 속성
1. transition
    - transition 스타일 속성에 영향을 받는 스타일 속성에 변화가 생겼을 때, 그변화를 지정한 시간에 걸쳐 진행하도록 하는 스타일 속성
    1. `transition-delay`: 변형을 시작하기 전에 얼마나 지연할 것인지 설정
    2. `transition-duration` : 변형을 얼마에 걸쳐 진행할 것인지 설정
    3. `transition-property` : 어떤 스타일 속성을 변형할지 설정
    4. `transition-timing-function` : 수치 변형 함수 설정

            <style>
                선택자 {
                    transition-delay:
                    transition-duration: 단위:s, ms
                    transition-property: 
                    transition-timing-function:
                }
            </style>
2. animation
    1. animation 스타일 속성
        1. `animation-delay` : 이벤트 발생 후 몇 초 후에 재생할지 설정
        2. `animation-direction` : 애니메이션의 진행 방향을 설정
        3. `animation-duration` : 애니메이션을 재생할 시간을 설정
        4. `animation-iteration-count` : 애니메이션의 반복 횟수를 설정
        5. `animation-name` : 애니메이션에 적용한 @keyframes 규칙의 이름을 지정
        6. `animation-play-state` : 애니메이션의 재생 상태를 설정
        7. `animation-timing-function` : 적용할 수치 변형 함수를 설정
    2. 키 프레임 규칙(Keyframes @-rule)
        - animation 스타일 속성이 지정된 요소에 적용할 스타일 속성을 설정하는 속성
        - 키프레임 안에는 퍼센트 단위로 시간이 지났을 때 적용할 CSS 블록을 작성
        - 예외적으로 0%와 100%는 from 키워드와 to 키워드를 사용
        - 작성하는 방법 
        ```        
        <style> 
            @keyframes name {
                from {...;} 
                25% {...;} 
                50% {...;} 
                to {...;}  
            }
        </style>
    
## transform 스타일 속성

- transform 스타일 속성이란 HTML 요소를 변환하는 속성이다.
- transform 의 2차 변환 함수
    1. rotate() : 지정한 각도(degree) 만큼 회전 - 단위 deg
    2. scale() : 지정한 배수만큼 확대 혹은 축소 (x축과 y축의 함수 제공) - 단위 scale
    3. translate() : 지정한 크기만큼 이동(x축과 y축의 함수 제공) - 단위 length, percent
    4. skew() : 지정한 각도만큼 기울임 (x 축과 y축의 함수 제공) - 단위 deg


* import 규칙
    - 스타일 시트에서 다른 스타일 시트를 불러우는 추가 규칙이다.
    - 성능이 좋지 않으니 HTMl 문서에서 `<link>` 요소로 대체하는 것이 좋다.
* @font-face 규칙
    - 사용자의 컴퓨터에 설치되지 않은 글꼴을 다운로드 해서 사용하도록 하는 추가 규칙이다.
        - 글꼴 파일을 사용자의 브라우저에서 다운로드 해서 사용하도록 한다.
    - 폰트 파일 용량 등의 문제로 인해 많이 사용하지 않는다.

## 반응형 웹

- 반응형 웹
    - 콘텐츠 하나에 HTML 파일이 하나만 존재함
    - 특정 장치에 최적화 된 HTML 파일이 여러개 있으면 "반응형"이라고 하지 않음
    - 특정 장치에 최적화 된 페이지로 연결되는 URL이 있으면 "반응형" 이라고 하지 않음.
    - 정적인 기능과 고정적인 콘텐츠를 갖고 있는 웹 사이트 (블로그, 회사 소개페이지, 커뮤니티 등)
    - 단점으로는 많은 콘텐츠를 표현해야 할 때에는 적합하지 않음.

    * 반응형 웹 에서는 3단계로 화면 너비를 구분한다.
        - 모바일 웹: (max-width: 767px)
        - 태블릿 pc: (min-width: 768px) and (max-width: 1023px)
        - 일반 웹 페이지: (min-width: 1024px)
1. 미디어 쿼리
    - 반응형 웹 페이지를 만들기 위해 @media 추가 규칙 표현식으로 작성해야 한다.
    - 미디어 타입과 미디어 속성의 상태를 확인하는 표현식으로 구성된다.(미디어 상태를 확인하는 속성은 생략할 수 있음)
    * 미디어 속성
        - `width, height` : 화면의 너비와 높이 (min, max)
        - `device-width, device-height` : 기기의 너비와 높이 (min, max)
        - `orientation` : 기기의 방향
        - `device-aspect-ratio` : 화면의 비율 (min, max)
        - `color, color-index` : 색상 비트와 표현할 수 있는 최대 색상 개수(min, max)
        - `resolution` : 해상도(min, max)
        - 작성 하는 방법 
                
        ```
        <style>
            @media screen and (max-width: 767px){
                선택자 {
                
                }
            }
        </style>
