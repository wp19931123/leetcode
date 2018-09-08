package exam.qi360;

import java.util.Scanner;

public class QiHu3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i = 0;i < n;i++) {
            A[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++) {
            B[i] = sc.nextInt();
        }
        System.out.println(maxNum(A,B,n));
    }

    private static int maxNum(int[] a, int[] b, int n) {


        return 2;
    }
}
