package cn.leetcode.hard;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length]; //保存每行各个位置为底的最多‘1’的个数
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;   //更新数组
            }
            maxArea = Math.max(maxArea, new LargestRectangleArea().largestRectangleArea2(height));
        }

        return maxArea;
    }
}
