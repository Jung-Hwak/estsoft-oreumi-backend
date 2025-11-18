# 오늘 배운 내용

## CSS의 글자 스타일

1. line-height
    - 글자의 행의 높이를 지정 하는 스타일 속성이고 글자 크기의 배수나 단위로 행의 높이를 지정할수있다.
    - 텍스는 행의 가운데에 배치되고 영어와 한글의 기본적인 높이에 차이가 있다.
    - 행의 제일 위쪽과 아래쪽의 사이의 길이는 같다.                                                 
    - line-height 행의 위치를 조정 하는 단위로는 'normal', ..px, ..em, ..rem, ..% 등이 있다.(음수로 지정 가능)
2. font 스타일 속성
    - font: 속성을 사용할때 font-size, font-family 스타일 속성의 값은 생략할 수 없다.
    - `font:` 로 여러 값을 설정 할수 있고 font-size 와 line-height 스타일 값을  구분하기위해 `/`를 넣어주고, font: 를 이용하지않고 개별적으로 지정해주는게 좋다.

3. text-align

4. text-decoration
    - 텍스트를 꾸며주기 위한 스타일 속성
    - color, line, style, thickness
5. text-indent
    - 텍스트의 첫 번째 줄의 들여쓰기 너비를 지정할수있다.
    - 음수로 지정하여 내어쓰기가 가능하다.
6. `<pre>(preformatted)` 태그
    - 요소 내의 텍스트를 HTML문서에 작성한 공백 문자 그대로 출력이 가능하다.
    - 기본 글꼴은 "monospace"로 지정 되어있고, white-space 라는 속성이 pre 로 지정되어있다.
7. white-space 스타일
    - 요소의 내부 텍스트에 포함되어있는 공백 문자를 어떻게 할지 지정할 수 있다.
    - 기본값은 normal 이며, nowrap 공백 문자 여러개를 빈칸 하나로 처리하며 개행을 하지 않음
    - pre 공백 문자를 그대로 출력

8. 목록을 표현하는 스타일 속성
    - `<li>`에 적용 하는 것이 아닌 `<ul>, <ol>`에 적용하는 스타일 속성
    1. list-style-type 
        - 마커를 표시하는 모양을 설정하는 속성
    2. list-style-position
        - li 요소의 컨텐트 영영에 안과 혹은 바깥쪽에 마커를 설정하는 속성
    3. list-style-image
        - 마커를 대신하여 이미지를 설정하는 속성 `url("")`속성을 이용하거 이미지를 지정 가능
9. CSS 그림자 스타일 속성
    - 요소의 글자에 그림자 효과를 주거나, 요소의 상자에 그림자 효과를 줄 수 있다.
    - 텍스트와 상자에 그림자 효과를 주어 보다 입체적으로 표현이 가능하다.
    - x축, y축의 위치에 그림자 효과를 줄수있고 color으로 그림자 색상을 지정할 수 있다. 

## HTML 요소의 배치 방식과 위치 지정

1. CSS 위치 스타일 속성
    1. position
        - HTML 요소의 위치 설정 방식을 지정한다.
            - 기본값은 `static` 브라우저의 화면에 나오는 일반적인 문서의 흐름에 배치 되도록 지정
            - `relative` 상대적인 위치에 배치 
                - 요소가 문서의 일반적인 흐름에 따라 배치 되어있을 때의 영역을 기준으로 상대적인 위치
            - `absolute` 절대적인 위치에 배치
                - 문서의 일반적인 흐름에서 제거하며, 특정한 영역을 기준으로 위치 할 수있다.
                - 조상 요소중 가장 가까윈 위치 지정 요소의 padding을 포함하는 영역에 딱 붙거나, 위치 지정요소가 없으면 초기 컨테이닝 블록에 배치
                - 초기 컨테이닝 블록 이란 브라우저를 실행하였을 때 처음 보이는 화면이 초기 컨테이닝 블록이다. 
                - 꼭 필요한 상황이 아니라면 기본값인 static 인 문서의 일반적인 흐름에 따라 배치되는 게 가장 좋다
            - `fixed` 고정된 위치에 배치
                - 브라우저 화면을 기준으로 배치되어 있고, 컨테이닝 블록을 기준 영역이다.
    2. top, right, bottom, left
        - 기준 영역을 기준으로 해서 요소와의 간격을 얼마만큼 떨어지느냐 설정
    3. z-index
        - 위치 지정 요소의 쌓이는 순서를 지정한다.

## 각 스타일 속성의 % 단위의 기준

1. `width, height` : 컨테이닝 블록의 너비또는 높이
2. `margin, padding` : 컨테이닝 블록의 너비
3. `border-radius` : 방향에 따라, HTML 요소의 너비 또는 높이
4. `line-height HTML` : 요소의 글자 크기
5. `top, right, bottom, left` : 컨테이닝 블록의 너비 또는 높이
6. `transform: translate()` : HTML 요소의 너비 또는 높이


## CSS Flexible Box 레이아웃
    
- 요소들을 행 또는 열 단위로 배치하기 위한 레이아웃이다.
- 아이템 요소(Flex items)들이 나열 되어있는 것을 플렉스 컨테이너(Flax containers)라고 한다.
- 플렉스 컨테이너에 아이템 요소들이 배치되는 방향을 기본 축(main axis)라고 하고, 배치되는 방향에 직각을 이루는 축 을 교차 축(cross axis)라고 한다.
- flax containers 에 나열되어 있는 아이템 요소들의 메인축 방향의 크기를 메인 사이즈(main size) 크로스 축 뱡향의 크기를 크로스 사이즈(cross size) 라고 한다.

* 플렉스 컨테이너에게 지정할 수 있는 스타일 속성
    1. `display`: (flex, inline-flex); 
        - 컨터이너를 블록 형식or인라인 형식으로 지정하는 속성
    2. `flex-direction`: (row[`기본 값`], row-reverse, column, column-reverse); 
        - 아이템 요소들을 배치할 기본 축의 방향을 지정 하는 속성
    3. `flex-wrap`: (nowrap[`기본 값`], wrap, wrap-reverse); 
        - 모든 아이템 요소들을 한 핸에 배치할 여유 공간이 없을 때 줄바꿈을 할 것인지 지정하는 속성
    4. `flex-flow`: 
        - direction과 wrap의 스타일 속성을 한꺼번에 설정할수 있는 속성(기본값은 row와 nowrap)이다.
    5. `justify-content`:(noraml[`기본 값`], flex-start, flex-end, center, space-between, space-around, space-evenly); 
        - 기본 축(main axis) 상에서 아이템 요소들의 배치 기준점과 여백을 설정
        - `space-between` 첫 번째와 마지막 아이템 요소는 컨테이너의 약쪽긑에 붙이고, 아이템 요소들 사이의 간격을 똑같이 설정
        - `space-around` 아이템 요소들 좌우의 간격을 모두 똑같이 설정
        - `space-evenly` 컨테이너와 아이템 요소의 간격, 아이템 요소들 사이의 간격을 똑같이 설정
    6. `align-items`: (flex-start, flex-end, center, stretch[`기본 값`], baseline)
        - 교차 축 상에서 한 핸으로 배치된 아이템 요소들의 정렬 방법을 설정
    7. `align-content`: (flsx-start, flex-end, center, stretch[`기본 값`], space-between, space-around, spece-evenly) 
        - 교차 축 상에서 여러 행으로 배치된 아이템 요소들의 배치 기준점과 여백을 설정

* gap 스타일 속성
    - 플렉스 컨테이너나 그리드 컨테이너에 설정하는 스타일 속성이다. 
    - 아이템 요소들 사이의 간격을 설정하는 속성이다.

## overflow,float 스타일 속성

1. overflow
    - HTML 요소의 영역을 벗어난 콘텐츠를 어떻게 처리할지 설정하는 속성
    1. visible(`기본 값`) : HTML 요소의 영역을 벗어난 콘텐츠를 보여줌
    2. hidden : HTMl 요소의 영역을 벗어난 콘텐츠를 숨김
    3. scroll : 스크롤 바를 생성해 HTML 요소의 영역을 벗어난 콘텐츠를 볼수 있도록 함 
    4. auto : HTML 요소의 영역을 벗어난 콘텐츠가 있으면 스크롤 바를 생성
2. text-overflow
    - 영역을 벗어난 내부 텍스트를 어떻게 처리할 것인지 설정하는 속성
    1. clip(`기본 값`) : 영역을 벗어난 내부 텍스트를 숨김
    2. ellipsis : 영역을 벗어난 내부 텍스트를 숨기고 말 줄임표를 덧붙임
    3. string : 영역을 벗어난 내부 텍스트를 숨기고 string을 덧붙임 
3. float
    - HTML 요소를 문서의 일반적인 흐름에서 제거하고, 부유하는 요소(floating elements)로 설정
    - 이미지를 글자 위에 띄우기 위해 만들어진 속성
    1. none(`기본 값`) : HTML 요소를 띄우지 않고 원래 자리에 있도록 함
    2. left : HTML 요소를 띄우고 컨테이닝 블록의 왼쪽에 붙임
    3. right : HTML 요소를 띄우고 컨테이닝 블록으 오른쪽에 붙임

## 웹 페이지 레이아웃

1. 웹페이지 레이아웃
    - 웹 페이지의 구성 요소들을 효과적으로 정리, 배치 하는것
    - 헤더(Header), 내비게이션(navigation), 사이드바(side bar), 본문(content), 푸터(footer) 등으로 구분된다.
2. 구분 순서
    1. 웹 페이지 구상
    2. 웹 페이지의 구성 영역 분리
    3. 구성 영역을 행 단위로 분리
    4. 나누어진 행의 내부 영역을 분리