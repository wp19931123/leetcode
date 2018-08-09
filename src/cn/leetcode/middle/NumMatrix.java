package cn.leetcode.middle;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，
 * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * 你可以假设矩阵不可变。会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */
public class NumMatrix {

    int[][] help;
    int row = 0, col = 0;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            help = new int[row][col];
            return;
        }
        row = matrix.length;
        col = matrix[0].length;
        help = new int[row + 1][col + 1];  //空间换时间，加1的空间可以避免对边界的判断
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                help[i][j] = matrix[i-1][j-1] + help[i - 1][j] + help[i][j - 1] - help[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (help.length == 0 || row1 < 0 || col1 < 0 || row2 >= row || col2 >= col) {
            throw new RuntimeException("err");
        }
        return help[row2 + 1][col2 + 1] - help[row1][col2 + 1] - help[row2 + 1][col1] + help[row1][col1];
    }
}
