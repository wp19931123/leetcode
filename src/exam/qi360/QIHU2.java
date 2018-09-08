package exam.qi360;

import java.util.HashSet;
import java.util.Scanner;

public class QIHU2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = sc.nextInt();
        }
        int Q = sc.nextInt();
        int[][] qArr = new int[Q][2];
        for (int i = 0;i < Q;i++) {
            qArr[i][0] = sc.nextInt();
            qArr[i][1] = sc.nextInt();
        }

        //输出q行
        for(int i  =0;i < Q;i++) {
            System.out.println(getCount(arr,qArr[i][0],qArr[i][1]));
        }

        sc.close();
    }

    private static int getCount(int[] arr, int l, int r) {
        HashSet set = new HashSet();
        for(int i = l;i <= r;i++) {
            set.add(arr[i-1]);
        }
        return set.size();
    }
}
