package exam.huawei;

import java.util.Scanner;

public class HUAWEI02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[5];
        int[] w = new int[5];
        int C = 0;
        String[] str1 = sc.nextLine().split(",");
        for (int i = 0; i < 5; i++) {
            v[i] = Integer.valueOf(str1[i]);
        }
        String[] str2 = sc.nextLine().split(",");
        for (int i = 0; i < 5; i++) {
            w[i] = Integer.valueOf(str2[i]);
        }
        C = sc.nextInt();
        int res = knapsack01(w, v, C);
        System.out.println(res);
    }

    public static int knapsack01(int[] w, int[] v, int C) {
        if (w == null || v == null || w.length != v.length) {
            return 0;
        }
        int n = w.length;
        int[][] memo = new int[n][C + 1];
        for (int j = 0; j < C + 1; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++)
            for (int j = 0; j < C + 1; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j - w[i] >= 0) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - 1][j - w[i]] + v[i]);
                }
            }
        return memo[n - 1][C];
    }

}
