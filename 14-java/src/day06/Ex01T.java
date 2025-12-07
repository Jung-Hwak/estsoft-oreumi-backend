package day06;

public class Ex01T {
    public static void main(String[] args) {
        // 객체를 생성하기 이전에 클래스 식별자로 정적 멤버에 접근
        System.out.println("sampleT2.numInstances = " + SampleT.getNumInstances());
        System.out.println();
        // 객체 생성
        SampleT sampleT1 = new SampleT(10);       // SampleT#SampleT(int)
        SampleT sampleT2 = new SampleT(20);

        // 출력
        System.out.println("sampleT1.data = " + sampleT1.getData());
        System.out.println("sampleT2.data = " + sampleT2.getData());

        /*
        // SampleT 클래스 인스턴스의 개수를 출력
        System.out.println("sampleT1.numInstances = " + sampleT1.getNumInstances());
        System.out.println("sampleT2.numInstances = " + sampleT2.getNumInstances());
         */

        System.out.println("sampleT2.numInstances = " + SampleT.getNumInstances());
    }
}
