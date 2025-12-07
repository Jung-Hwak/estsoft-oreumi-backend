package day06;

public class SampleT {
    // 필드(fields)
    private int data;

    // 정적 변수(static variables; 클래스 변수)
    private static int numInstances = 0;

    // 정적 상수(static constant)
    // private static final int MAX = 255;     // private로 보호해서 해야하지만 public로 해도 괜찮다 상수이기 때문에
    public static final int MAX = 255;

    // 메서드(methods)
    public SampleT(int data) {
        this.data = Math.min(data, MAX);

        // 새로운 인스턴스가 생성될 때마다 정적 변수 numInstances를 증가
        numInstances++;
    }
    public SampleT() { this(0); }

    public void settData(int data) { this.data = Math.min(data, MAX); }
    public int getData() { return data; }

    // 정적 메서드(static methods)
    public static int getNumInstances() { return numInstances; }

    public void print() {
        System.out.println("data = " + data);
    }
}
