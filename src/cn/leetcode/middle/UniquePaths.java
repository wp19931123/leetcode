package cn.leetcode.middle;

/**
 * 一个机器人位于一个 m x n 网格的左上角,机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7,3));
    }

    //动态规划
    public int uniquePaths(int m, int n) {
        //总共要走m+n-2步
        if(m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++) {
            dp[i][0] = 1;
        }
        for(int i = 0;i < m;i++) {
            dp[0][i] = 1;
        }
        for(int i = 1;i < n;i++) {
            for(int j = 1;j < m;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[n-1][m-1];
    }
}
