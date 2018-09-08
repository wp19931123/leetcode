package cn.leetcode.middle;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] chs = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.print(new MaximalSquare().maximalSquare(chs));
    }

    /**
     * 动态规划的思路：
     * 考虑以某点为正方形的右下角时最大的正方形，该点为右下角的正方形的最大边长，
     * 最多比它的上方，左方和左上方为右下角的正方形的边长多1
     * 假设dp[i][j]表示以i,j为右下角的正方形的最大边长，则有
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int colum = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][colum];
        //初始化第一列
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        //初始化第一行
        for (int i = 0; i < colum; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }

        //迭代
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < colum; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
