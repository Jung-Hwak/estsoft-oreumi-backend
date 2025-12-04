package day05;

import java.util.Scanner;

public class Ex04T {
    /**
     * 원의 반지름을 전달받아, 원의 넓이를 구해 반환
     * 
     * @param radius 원의 반지름
     * @return 원의 넓이
     */
    public static double getAreaCircle(int radius) {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {
        // 변수 선언
        int radius;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter the radius of the circle: ");
        radius = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // getAreaCircle 메서드로 원의 넓이를 구해 출력
        System.out.printf("Area of the circle with radius %d = %g\n",
                radius, getAreaCircle(radius));
    }
}
