package day02;

import java.util.Scanner;

public class Ex07T {
    public static void main(String[] args) {
        // 사용자가 입력한 자연수를 저장할 변수
        int n1, n2;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자 입력
        System.out.print("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        // 입력 스트림(input stream) 닫기
        in.close();

        // if-else0-if 구문으로 변수 n1이 n2의 약수인지, 배수인지
        // 약수도 아니고 배수고 아닌지 확인
        if (n2 % n1 == 0)
            System.out.printf("%d is a factor of %d\n", n1, n2);
        else if (n1 % n2 == 0)
            System.out.printf("%d is a multiple of %d\n", n1, n2);
        else
            System.out.printf("%d is neither a factor of %d nor a multiple. \n", n1, n2);

    }
}
