package day05;

public class Ex08T {
    static void main() {
        // Sample 클래스의 인스턴스 생성
        SampleT sampleT = new SampleT(10);        // SampleT#SampleT(int);

        // spmpleT 객체의 print 메서드로 출력
        sampleT.print();

        // Sample 클래스의 기존 인스턴스로 새로운 객체를 초기화
        SampleT sampleT2 = new SampleT(sampleT);

        // sample 객체의 print 메서드로 출력
        System.out.println("sample2.data = " + sampleT2);
    }
}
