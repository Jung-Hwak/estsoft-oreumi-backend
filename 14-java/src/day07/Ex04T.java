package day07;

public class Ex04T {
    public static void main(String[] args) {
        // 객체 생성
        Sample sample1 = new Sample(10);        // Sample#Sample(int);
        Sample sample2 = sample1;

        // 출력
        System.out.println("sample1.data = " + sample1.getData());
        System.out.println("sample2.data = " + sample2.getData());
        System.out.println();

        // 객체 sample1에 새로운 값을 설정
        sample1.setData(20);

        // 출력
        System.out.println("sample1.data = " + sample1.getData());
        System.out.println("sample2.data = " + sample2.getData());
        System.out.println();

        // 같은 값을 가지는 새로운 객체를 생성
        sample2 = new Sample(sample1.getData());    // Sample#Sample(int);
        sample2 = new Sample(sample1);              // Sample#Sample(Sample);

        // 객체 sample1에 새로운 값을 설정
        sample1.setData(30);

        // 출력
        System.out.println("sample1.data = " + sample1.getData());
        System.out.println("sample2.data = " + sample2.getData());
        System.out.println();

        // sample1 객체를 복제해서 새로운 객체 생성
        Sample sample3 = sample1.clone();

        // 출력
        System.out.println("sample1.data = " + sample1.getData());
        System.out.println("sample2.data = " + sample2.getData());
        System.out.println("sample3.data = " + sample3.getData());
        System.out.println();

        // 비교 연산자(==)로 두 참조 변수가 같은 객체를 참조하는지 검사
        if (sample1 == sample3)
            System.out.println("sample1 and sample3 refer to the sample object.");
        else
            System.out.println("sample1 and sample3 refer to different objects.");

        System.out.println();

        // 객체 sample1에 새로운 값을 설정
        sample1.setData(40);

        // 출력
        System.out.println("sample1.data = " + sample1.getData());
        System.out.println("sample2.data = " + sample2.getData());
        System.out.println("sample3.data = " + sample3.getData());
        System.out.println();

        // equals 메서드로 두 객체가 같은 값을 가지고 있는지 확인
        if (sample1.equals(sample3)) {
            System.out.println("sample1 and sample3 have the same value.");
        } else {
            System.out.println("sample1 and sample3 have different values.");
        }

        System.out.println();

        // 출력
        System.out.println("sample1 = " + sample1);
        // → System.out.println("sample1 = " + (String)sample1);
        // → System.out.println("sample1 = " + sample1.toString());
    }
}