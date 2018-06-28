package cn.leetcode.middle;

/**
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 输入:
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * 输出: 2
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        if(m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if( n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 1;i < m;i++) {
            if(obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i = 1;i < n;i++) {
            if(obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
