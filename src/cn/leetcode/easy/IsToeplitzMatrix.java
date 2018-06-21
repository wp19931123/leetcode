package cn.leetcode.easy;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 */
public class IsToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int colum = matrix[0].length;
        for(int i = 0;i < row;i++) {
            int j = 1;
            while(i < row && j < colum) {
                if(matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
                i++;j++;
            }

        }

        return true;
    }
}
