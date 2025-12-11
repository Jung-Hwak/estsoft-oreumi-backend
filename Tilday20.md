# 오늘 배운 내용

## Java

### 코딩 테스트

- 소프트웨어 개발 분야에서 지원자의 기술 역량을 평가하는 시험
- 주로 알고리즘 문제 해결 능력과 코딩 능력을 평가한다.
- 3~6시간 안에 3~5문제 가량을 풀어야 하는 집중력, 알고리즘, 문제 접근 능력등이 주요하다.

### 알고리즘

- 어떠한 문제를 효율적으로 해결하는 방법(명령어들의 집합)
- 알고리즘의 조건으로는 입력 - 출력 - 명확성 - 유한성 - 효과성을 가져야한다.
- 정해진 시간내에 한정적인 자원을 가지고 얼마나 빠르게 얼마나 적은 자원을 가지고 풀어 낼수 있는지를 따져 효율적인 알고리즘을 찾아야한다.

### 완전 탐색(Brute Force Search)

- 전수 조사 알고리즘, 또는 맹목적 탐색 알고리즘이라고도 하며, 가능한 모든 경우의 수를 모두 탐색해서 요구 조건에 충족되는 결과를 찾는다.
- 연산 횟수가 적을때 완전 탐색을 이용해 찾을수 있다.

### NullPointerException 예외

- NullPonterException 예외
    ```
    List<String> values = getValues();
    values.srot();
    getValues 메서드가 null을 반환하면, sort 메서드를 호출할때 null을 참조하려고 시도하므로
    NullPonterException 예외가 발생한다. 이릉 방지하기 위해 예외처리를 하거나
    getValues 메서드의 반환 값이 null인지 검사해야 한다.
    List<String> values = getValues();
    if (values != null) {
        values.sort();
    } 이와 같은 식으로 프로그램을 작성하면 코드가 복잡해지고 번거롭다. 그리고 이런 상황은 아주 빈번하게 발생한다.
    Java 프로그램에서 가장 많이 발생하는 예외 중 하나가 NullPonterException 예외이다. 

### 널포인트익셉션을 방지 하기위한 메서드
  - java.util 패키지의 Optional<T> 클래스를 사용하여 방지 한다.
  - Java 8에서 도입된 클래스로, NullPonterException 예외를 방지하고, null을 보다 명확하게 처리하도록 돕는 기능을 제공한다.
  - null이 올 수 있는 객체를 감싸는 래퍼 클래스(wrapper classes)
    ```
    public final class Optional<T> {
        private static final Optional<?> EMPTY = new Optional<>();
        private final T value;
        
        private Optional() {
            this.value = null;
        }
    }
