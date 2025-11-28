package day01;

public class Ex01T {
    static void main(String[] args) {
        /*
        // 변수의 선언
        int value;
        double factor;
        char grade;

        // 변수의 값을 대입
        value = 100;
        factor = 0.98;
        grade = 'A';
        */

            // 변수의 선언과 초기화
            int value = 100;
            double factor = 0.98;
            char grade = 'A';

            // 출력
            // Value: 100, Factor = 0.98, Grade = 'A';
            System.out.println("value: " + value + ", Factor: " + factor + ", Grade: " + grade);

            // System.out 객체의 printf 메서드로 출력
            System.out.printf("Value: %d, Factor: %f%n, Grade: %c\n", value, factor, grade);

            // 형식 태그에 정밀도를 지정해서 소수점 이하 둘째 자리까지 출력
            System.out.printf("Value: %d, Factor: %.2f, Grade: %c\n", value, factor, grade);

    }
}


