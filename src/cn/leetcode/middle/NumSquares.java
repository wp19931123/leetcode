package cn.leetcode.middle;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.print(new NumSquares().numSquares(12));
    }

    /**
     * 动态规划
     * dp[i]表示由若干个数的平方和组成i的最少个数
     * dp[i] = 1 + dp[i - j*j],(j * j <= i, j >= 1)。
     * 特殊情况，比如，12 / (2*2) = 3，所以 dp[i] = i / (j*j), (i % (j * j) == 0。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i % (j * j) == 0) {
                    dp[i] = Math.min(dp[i],i / (j * j));
                } else {
                    dp[i] = Math.min(dp[i],1 + dp[i - j * j]);
                }
            }
        }
        return dp[n];
    }
}
