package JavaDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class divisor {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> tempList = new ArrayList<>();

        // for (int i = 0; i < arr.length; i++) {
        for (int currentNumber : arr) {
            if (currentNumber % divisor == 0) {
                tempList.add(currentNumber);
            }
        }

        if (tempList.isEmpty()) {
            // int[] answer = {-1};
            return new int[]{-1};
        }

        Collections.sort(tempList);

        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
            divisor div = new divisor();

            int[] arr1 = {5, 9, 7, 10};
            int[] arr2 = {2, 36, 1, 3};
            int[] arr3 = {3, 2, 6};
            int divisor1 = 5;
            int divisor2 = 1;
            int divisor3 = 10;
            int[] result1 = div.solution(arr1, divisor1);
            int[] result2 = div.solution(arr2, divisor2);
            int[] result3 = div.solution(arr3, divisor3);

            System.out.println(Arrays.toString(result1));
            System.out.println();
            System.out.println(Arrays.toString(result2));
            System.out.println();
            System.out.println(Arrays.toString(result3));
    }
}
