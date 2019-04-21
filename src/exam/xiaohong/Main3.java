package exam.xiaohong;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(numOf1(n));
        sc.close();
    }

    static long numOf1(int n) {
        long num1 = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = (int) (n / m), b = (int) (n % m);
            long temp = (a % 10 == 1) ? (b + 1) : 0;
            num1 += (a + 8) / 10 * m + temp;
        }
        return num1;
    }
}