package exam.xunlei;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int res = getMaxSum(A, B);
        System.out.println(res);
        sc.close();
    }

    private static int getMaxSum(int a, int b) {
        int[] arr = new int[17];
        if (a > -b) {

        } else {
            //b的绝对值比较大
            int bei = -b / a;
            arr[6] = b;

        }

        return 0;
    }
}
