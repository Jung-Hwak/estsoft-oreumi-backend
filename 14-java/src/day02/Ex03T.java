package day02;

import java.util.Scanner;

public class Ex03T {
    public static void main(String[] args) {
        // 변수의 선언과 초기화
        int radius;
        final double PI = 3.141592;
        double area;
        double circumference;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter a radius of circle as an integer: ");
        radius = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // 원의 넓이와 둘레 계산
        area = PI * radius * radius;
        circumference = 2 * PI * radius;

        // 출력
        System.out.println("pi = " + PI);
        System.out.println("radius of the circle = " + radius);
        // System.out.println("area = " + area);
        // System.out.println("circumference of the circle =" + circumference);
        System.out.printf("area of the circle = %.3f\n ", area);
        System.out.printf("cricumference of the circle = %.3f\n", circumference);
    }
}
