package exam.xiecheng;

import java.util.Scanner;

public class XC1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        System.out.println(res);
    }

}
