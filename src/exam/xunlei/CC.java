package exam.xunlei;

import java.util.Scanner;

public class CC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getCount(num));
    }

    public static int getCount(int num) {
        int n = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = i + 1; j <= num; j++) {
                for (int k = j + 1; k <= num; k++) {
                    if (((i * i + j * j) == k * k) && gcd(i, j) && gcd(j, k) && gcd(i, k)) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    //判断是否互质
    public static boolean gcd(int a, int b) {
        int c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        if (b == 1) {
            return true;
        }
        return false;
    }
}
