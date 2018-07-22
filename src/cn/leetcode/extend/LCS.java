package cn.leetcode.extend;

public class LCS {

    public static void main(String[] args) {
        System.out.println(new LCS().longestCommonSubsequence("TCGGATCGACTT","AGCCTACGTA"));
    }

    //动态规划
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        if(m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = A.charAt(0) == B.charAt(0) ? 1 : 0;
        if(m == 1 && n == 1) {
            return dp[0][0];
        }
        if(m == 2 && n == 1) {
            return A.charAt(0) == B.charAt(0) || A.charAt(1) == B.charAt(0) ? 1 : 0;
        }
        if(m == 1 && n == 2) {
            return A.charAt(0) == B.charAt(0) || A.charAt(0) == B.charAt(1) ? 1 : 0;
        }
        dp[1][0] = A.charAt(0) == B.charAt(0) || A.charAt(1) == B.charAt(0) ? 1 : 0;
        dp[0][1] = A.charAt(0) == B.charAt(0) || A.charAt(0) == B.charAt(1) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
