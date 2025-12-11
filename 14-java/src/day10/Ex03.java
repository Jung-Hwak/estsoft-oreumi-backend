package day10;

import java.util.*;

public class Ex03 {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int currentNumber : arr) {
            if (tempList.isEmpty() || tempList.getLast() != currentNumber) {
                tempList.add(currentNumber);
            }
        }
        int[] answer = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}