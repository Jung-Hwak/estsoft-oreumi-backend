package day07;

/**
 * Sample 클래스의 인스턴스를 복제하기 위해 java.lang.Cloneable 인터페이스를 구현해서
 * clone 메서드를 재정의해야 한다.
 */

public class Sample implements Cloneable {
    // 필드(fields)
    private int data;

    // 메서드(methods)
    public Sample(int data) { this.data = data; }
    public Sample() { this(0); }

    // 복사 생성자(copy constructor)
    public  Sample(Sample copy) { this(copy.data); }

    public int getData() { return data; }
    public void setData(int data) { this.data = data; }

    public void print() {
        System.out.print("data = " + data);
    }

    /*
     * Cloneable 인터페이스의 clone 메서드 재정의
     * → public abstract Object Cloneable.clone();
     */
    @Override
    public Sample clone() {
        /*
         * clone 메서드를 재정의할 때는 CloneNotSupportedException 예외를 처리해야 한다.
         */
        try {
            return (Sample)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /*
     * Object 클래스의 equals 메서드 재정의
     * → public boolean Object.equals(Object obj);
     */
    @Override
    public boolean equals(Object obj) {
        // 매개 변수에 전달된 객체가 이 객체인지 확인
        if (obj == this) return true;

        // 매개 변수에 전달된 객체가 Sample 클래스의 인스턴스가 아닌지 확인
        // if (obj == null || getClass() != this.getClass()) return false;
        if (!(obj instanceof Sample)) return false;

        // Object 자료형인 매개 변수 obj를 Sample 자료형으로 변환
        Sample other = (Sample)obj;

        // 이 객체의 필드와 매개 변수에 전달된 객체의 필드가 같은지 확인해서 반환
        return this.data == other.data;
    }

    /*
     * Object 클래스이 toString 메서드 재정의
     * → public String Object.toString();
     */

    @Override
    public String toString() {
        // return "Sample{" + "data=" + data + '}';
        return String.format("{data: %d}", this.data);
    }
}
