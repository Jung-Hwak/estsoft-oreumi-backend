package JavaDemo;

import java.util.Scanner;

public class Demo1210 {
    public static void main(String[] args) {
        int n1, n2;
        int result;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();
        in.close();
        result = GCD(n1, n2);
        long lcm = LCM(n1, n2 , result);

        System.out.printf("The greatest common divisor of %d and %d = %d\n", n1, n2, result);
        System.out.printf("The least common multiple of %d and %d = %d\n", n1, n2, lcm);

    }
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
    public static long LCM(long a, long b, int GCD) {
        if (b == 0) return a;
        return (a * b) / GCD;
    }
}
