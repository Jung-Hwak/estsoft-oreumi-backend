package day04;

public class Ex03T {
    public static void main(String[] args) {
        // 배열을 생성하고 배열 참조 변수로 참조
        // int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // for 구문으로 배열 numbers의 원소에 차례대로 접근
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d]= %d\n", i, numbers[i]);
        }

        System.out.println();

        // for-each 구문으로 배열 numbers의 원소에 차례대로 접근
        for (int item : numbers) {
            System.out.println("item = " + item);
        }
    }
}
