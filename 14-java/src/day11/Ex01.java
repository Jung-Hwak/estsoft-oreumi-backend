package day11;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String Ba = "banana";
        int[] result1 = sol.solution(Ba);
        System.out.println(Ba +  Arrays.toString(result1));

        System.out.println();

        String Fo = "foobar";
        int[] result2 = sol.solution(Fo);

        System.out.println(Fo + Arrays.toString(result2));
    }
}

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }
}