package exam.netease.net2;

import java.util.Scanner;

//买房子
public class AA {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count;i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println("0 " + getMax(n, k));
        }
    }

    private static int getMax(int n, int k) {
        if (n <= 2 || k >= n)
            return 0;

        int count = 0;
        int r = n - k;
        k--;
        while (r > 0 && k > 0) {
            r--;
            k--;
            count++;
        }

        return count;
    }

}
