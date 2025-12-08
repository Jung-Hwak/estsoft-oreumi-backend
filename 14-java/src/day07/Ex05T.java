package day07;

import JavaDemo.InvalidScoreException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex05T {
    public static void main(String[] args) {
        // 변수 선언
        int korean;
        int math;
        int english;
        double average;

        // Scanner 클래스의 인스턴스 생성
        Scanner in = new Scanner(System.in);

        // 사용자가 유효한 값을 입력할 때까지 반복문을 수행
        while (true) {
            // try-catch 구문으로 예외 처리
            try {
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
                } else if (korean > 100 || math > 100 || english > 100) {
                    throw new InvalidScoreException();
                }

                // 사용자가 유효한 값을 입력한 경우 반복문을 종료
                break;
            } catch (Exception e) {
                // InputMismatchException 예외가 발생한 경우
                if (e instanceof InputMismatchException) {
                    // Scanner 클래스의 입력 메서드가 지정한 자료형 값을 읽어오지 못해
                    // InputMismatchException 예외가 발생하면, 읽어오지 못한 그 값은
                    // 입력 스트림에 그대로 남아 있게 된다.
                    // 입력 스트림에 남아 있는 값을 모두 읽어와야 사용자가 다시 값을 입력하고
                    // Scanner 클래스의 입력 메서드로 그 값을 읽어올 수 있다.
                    in.nextLine();

                    System.out.println();
                }

                System.out.println("ERROR: Invalid input.");
                System.out.println("Try again.\n");
            }

            /*
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (NegativeScoreException e) {
                System.err.println(e.getMessage());
            } catch (InvalidScoreException e) {
                System.err.println(e.getMessage());
            }
            */
        }

        // 입력 스트림(input stream) 닫기
        in.close();

        // 평균 점수를 계산
        average = (double)(korean + math + english) / 3;

        // 출력
        System.out.println("Average: " + average);
    }
}
