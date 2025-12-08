package day07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03T {
    public static void main(String[] args) {
        // 변수 선언
        int korean;
        int math;
        int english;
        double average;

        // Scanner 클래스의 인스턴스 생성
        // try-catch 구문으로 예외 처리
        try (Scanner in = new Scanner(System.in)) {
            // 사용자 입력
            System.out.print("Enter Korean score: ");
            korean = in.nextInt();

            System.out.print("Enter Math score: ");
            math = in.nextInt();

            System.out.print("Enter English score: ");
            english = in.nextInt();
            System.out.println();

            // 사용자가 입력한 점수를 검사
            if (korean < 0 || math < 0 || english < 0) {
                throw new NegativeScoreException();
            }

            // 평균 점수를 계산
            average = (double) (korean + math + english) / 3;

            // 출력
            System.out.println("Average: " + average);
        } catch (NegativeScoreException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }
}