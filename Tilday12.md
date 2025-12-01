# 오늘 배운 내용

## Java 프로그래밍

1. 스트림과 버퍼
    - 운영 체제에서는 물리적인 장치 등을 `스트림` 이라는 논리적인 장치로 처리한다.
    - 프로그램에서 입력, 출력을 하려면 운영 체제에게 요청을 해서 스트림을 생성해야 한다.
    - 자바 애플리케이션 에서 모든 입출력은 스트림을 통해 이루어진다.
2. System 클래스의 표준
    - static PrintStream 
    - static InputStream
    - static OutputStream
    1. System.out 객체의 출력 메서드
        1. System.out.print
        2. System.out.println 
        3. System.out.printf 
           - 표준 출력에 형식 문자열을 출력 하는 메서드이고
           - 형식 문자열 안에는 형식 태그가 들어갈수 있다
           * 형식 태그란[ % 플래그  ]
    2. 문자열의 형식 지정
        - String.format 메서드  
        - System.out