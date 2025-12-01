package day02;

import java.util.Scanner;

public class Ex06T {
    public static void main(String[] args) {
        // 변수 선언
        int n1, n2;

        // Scanner 클래스 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter an integer: ");
        n1 = in.nextInt();
        n2= in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // if-else 구문으로 변수 n1과 n2 중에서 큰 수에서 작은 수를 뺀 값을 출력
        if (n1 > n2)
            System.out.printf("max - min = %d\n", n1 - n2);
        else
            System.out.printf("max - min = %d\n", n2 - n1);

        // !(n1 > n2)
        // → n1 <= n2
        // → n1 < n2 || n1 == n2

        // ------------------------------------------------------------------
        // 조건 연산자로 변수 n1과 n2중에서 큰 수와 작은 수를 확인
        int max = n1 > n2 ? n1 : n2;
        int min = n1 < n2 ? n1 : n2;
        
        // 출력
        System.out.printf("max - min = %d\n", max - min);

        // ------------------------------------------------------------------
        // Math 클래스의 max, min 메서드로 두 값 중에 큰 수와 작은 수를 확인
        max = Math.max(n1, n2);
        min = Math.min(n1, n2);

        // 변수 max에서 min을 뺀 값을 출력
        System.out.printf("max - min = %d\n", max - min);

        // ------------------------------------------------------------------
        // 조건 연산자로 변수 n1과 n2중에서 큰 수와 작은 수를 확인해서
        // 큰 수에서 작은 수를 뺀 값을 구해 변수 delta에 대입
        int delta = n1 > n2 ? n1 - n2 : n2 - n1;
        
        //출력
        System.out.printf("max - min = %d\n", delta);
    }
}
