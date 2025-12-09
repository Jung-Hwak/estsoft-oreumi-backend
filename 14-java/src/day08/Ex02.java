package day08;

import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        final int LENGTH = 6;
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() != LENGTH) {
            int number = random.nextInt(45);
            numbers.add(number);
        }

        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);

        System.out.println("numbers = " + list);
    }
}
