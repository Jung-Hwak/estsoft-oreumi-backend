# 오늘 배운 내용

## JAVA

### Java 클래스


1. java.lang.String 클래스
   - char 자료형 배열과 그에 관련된 메서드들이 정의되어 있다.
   - String 클래스의 인스턴스는 내용을 바꿀 수 없다
   - String을 초기화 할때는 빈 문자열("")로 초기화하고, char을 초기화할 때는 (" ")따옴표 사이 공백 문자(white space)로 초기화한다.
   - 문자열을 연결할때는 + 덧셈 연산자로 연결할 수 있다. String 클래스의 인스턴스 내용은 변경할 수 없지만 문자열의 내용기 변경되면, 그내용을 가지는 새로운 문자열을 생성한다.
  
2. StringBuffer 클래스와 StringBuilder 클래스
   - String 클래스와 비슷하게 char 자료형 배열과 관련된 메서드들이 정의되어 있다.
   - String 클래스와는 다르게 내용을 바꿀 수 있다.
   - StringBuffer 클래스와 StringBuilder 클래스는 주로 내용을 추가하면서 문자열을 만들 때 사용한다.
  
3. Math 클래스
   - 수학과 관련된 정적 상수와 정적 메서드로 구성이되어 있다.
   - 정적 상수에는 원주율을 나타내는 Math.PI와 오일러 수인 Math.E가 있다.

4. Java.lang.Class
   - class 클래스의 인스턴스는 실행중인 객체의 클래스를 나타낸다.
   - Java의 가상 기계 JVM에 의해 자동생성이 된다. 
   - class 클래스의 인스턴스를 이용하면 객체의 클래스 식별자를 확인할 수 있다.

5. Java.lang.System
   - System 클래스는 실행 시스템과 관련된 정적 상수와 정적 메서드를 제공한다.
   - PrintStream - err : 표준 오류 철력 스트림
   - InputStream - in : 표준 입력 스트림
   - PrintStream - out : 표준 출력 스트림 
6. 래퍼 클래스
   - java.lang 클래스의 하나이다.
   - 원시 자료형값을 객체로 포장하는 클래스
   - 원시 자료형의 값과 1대1로 매치되는 래퍼 클래스가 존재한다.
  
7.  java.util 패키지
   - Arrays : 배열과 관련된 정적 메서드를 가지고 있는 클래스(클래스 식별자로 접근한다.)
   - Calendar : 날짜와 시간과 관련된 기능을 제공
   - Scanner : 입력 스트림과 연결되는 보조 스트림을 제공
   - Collections : 컬렉션 프레임워크와 관련된 인터페이스와 클래스

8.  java.util.Arrays 클래스
    - List<T> - asList(T... a) : 배열을 고정 길이 리스트로 변환 
    - int - binarySearch(int[] a, int key) : 배열을 이진 탐색해서 인덱스 반환 
    - int - binarySearch(int[] a, int fromIndex, int toIndex, int key)  
    - int - binarySearch(Object[] a, Object key ) : 배열을 이진 탐색해서 인덱스 반환 
    - Arrays 클래스의 메서드들은 정적 메서드이다. 


9.  java.util.Random 클래스
    - (반환값) boolean nextBoolean() : boolean 자료형 난수 생성
    - (반환값) void - nextBytes(byte[] bytes) : byte 자료형 난수를 만들어 주어진 배열을 채운다
    - (반환값) netxDouble() : 0.0 <= x < 1.0 범위의 double 자료형 난수 생성
    - (반환값) nextFloat() : 0.0 <= x  < 1.0 범위의 float 자료형 난수 생성
    - (반환값) nextInt() : int 자료형 난수 생성
    - (반환값) nextInt(int n) : 0 <= x < n 범위의 int 자료형 난수 생성
    - (반환값) nextGaussian() : 평균 0.0, 표준 편차 1.0인 정규 분포에서 난수 생성
    - (반환값) setSeed(long seed) : 시드(Seed) 설정
### 제네릭 프로그래밍(Genric programming)

- 다양한 자료형 값을 가지는 객체들을 동일한 코드로 처리하는 기법
- 제네릭은 컬렉션 프레임워크(Collection framework) 
    ```  
    public class Box {
        private Object data;
        public void set(Object data) { this.data = data' }
        public Object get() { return data; }
    }
- 제네릭은 클래스, 인터페이스가 아닌 클래스, 인터페이스의 틀이다.
1. 제네릭 클래스
  - 필드 또는 메서드에서 다양한 자료형을 사용할 수 있도록 하는 클래스
  - 클래스 식별자 다음에 (<>)와 타입 매개 변수를 지정한다.
  - 참조 변수를 선언 하거나 객체를 생성할 때 타입 매개 변수에 자료형이 전달되며, 이 자료형으로 필드 또는 메서드 등의 자료형을 결정한다.
  
2. 제네릭 클래스의 타입 매개 변수
   - 타입 매개 변수는 제네릭 클래스의 필드나 메서드에서 다양한 자료형을 쓸 수 있게 한다.
   - 제네릭 클래스를 정의하면서 필드나 메서드의 자료형을 타입 매개 변수로 지정한다.
   - 참조 변수를 선언하거나 객체를 생성할 때 타입 매개 변수에 전달할 자료형을 지정하며, 이 자료형으로 새로운 클래스가 생성되면서 필드나 메서드의 자료형이 결정된다. 
   - 타입 매개 변수의 값으로는 원시 자료형은 지정하지 못하며 참조 자료형만 올 수 있다.
 
3. 제네릭 메서드
  - 사용자가 메서드를 만들기위한 틀이다.
  - 메서드 타입 매개 변수를 사용해 제네릭 메서드를 정의할 수 있다.
  - 타입 매개 변수의 범위는 메서드 내부로 제한된다.
### 와일드 카드

  - 물음표(?)로 표현되며 와일드 카드라고 부르며, 어떤 자료형이든 나타낼수 있다.

### 컬렉션 프레임워크(Collection framework)

1. 컬렉션
   - Java 에서 제공하는 자료 구조를 구현한 인터페이스들과 클래스들이다.
   - 자료 구조로는 종류 리스트(list), 스택(stack), 큐(queue), 집합(set), 해시 테이블(hash table)등이 있다.
     - Collection<E> : 컬렉션 프레임워크의 최상위 인터페이스로 객체의 묶음을 나타낸다.
       - Collection<E>의 인터페이스의 기본연산 
         - `int` - size() : 요소들의 개수 반환
         - `boolean` - isEmpty() : 컬렉션 객체가 비어 있는지 검사
         - `boolean` - contains(Object obj) : 요소들 중에서 obj가 포함되어 있는지 검사
         - `boolean` - add(E elemnt) : eLemnet를 새로운 요소로 추가
         - `boolean` - remove(Object obj) : 요소들 중에서 obj를 제거
         - `Iterator<E>` - iterator() : 모든 요소에 차례대로 접근할 수 있는 반복자 생성
         - `void` - forEach(Consumer<T> action) : 요소들을 대상으로 action을 실행
     - List<E> : 배열처럼 순서가 있는 자료 구조로, 중복된 요소를 가질 수 있다.
       - 배열처럼 순서가 있는 자료 구조이며, 가변크기배열을 구현하고 있어 가장 많이 쓰인다.
       - 요소의 저장 순서가 유지되며, 중복된 요소를 허용한다.
     - Set<E> : 집합(중복된 요소를 가지지 않는)을 나타내는 자료 구조
     - Queue<E> : 극장의 대기줄과 같이 들어온 순서대로 나가는 자료 구조
     - Map<K, V> : 키와 값의 쌍으로 이루어진 데이터들의 묶음으로, 사전과 같은 형태의 자료 구조
* 자료구조
  - 프로그램에서 사용하는 데이터들을 표현하고 저장하는 방법
  - 추상자료형(ADT; Abstract Data Types)
    - 알고리즘으로 문제를 해결하는데 필요한 자료의 형태와 자료를 사용한 연산들을 정의한 수학적 모델
    - 자료 구조는 추상 사료형이 정의한 연산들을 구현한 구현체이다.
* 알고리즘
  - 문제를 해결하는데 있어 효율적인 방법
  - 결과물의 효율성을 위해 좀더 그문제에 맞는 알고리즘을 찾아보고 고민해봐야 한다.
* 자료 구조와 알고리즘
  - 자료 구조에 따라 알고리즘이 달라진다.
  - 알고리즘은 자료구조에 의존적이다.