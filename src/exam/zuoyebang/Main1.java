package exam.zuoyebang;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(1<<30);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 1) {
            return;
        }
        double res = 0;
        if (num % 2 == 1) {
            for (int i = 1; i <= num;
                 i += 2) {
                res += 1.0 / Double.valueOf(i);
            }
        } else {
            //偶数
            for (int i = 2; i <= num; i += 2) {
                res += 1.0 / Double.valueOf(i);
            }
        }
        System.out.println(res);
    }
}