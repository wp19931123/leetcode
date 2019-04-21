package exam.xunlei;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) {
            return;
        }
        int count = getGouGuNum(n);
        System.out.println(count);
        sc.close();
    }

    public static int getGouGuNum(int num) {
        int count = 0;
        for (int i = 1; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                int sum = i * i + j * j;
                int c = (int) Math.sqrt(sum);
                if (c * c == sum && c < num && gcd(i, j) == 1 && i <= Math.sqrt(sum) && j <= Math.sqrt(sum)) {
                    count++;
                    //System.out.println(i + "," + j + "," + c);
                }
            }
        }
        return count;
    }

    //    public static boolean isHuZhi(int a,int b,int c) {
//        if(gcd())
//    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
