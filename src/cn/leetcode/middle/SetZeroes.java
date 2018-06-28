package cn.leetcode.middle;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class SetZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetZeroes().setZeroes(matrix);
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //空间复杂度为O(m+n)，时间复杂度O(m*n)
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int colum = matrix[0].length;
        int[] R = new int[row];
        int[] C = new int[colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (matrix[i][j] == 0) {
                    R[i] = 1;
                    C[j] = 1;
                }
            }
        }
        //删除行
        for (int i = 0; i < row; i++) {
            if (R[i] == 1) {
                for (int k = 0; k < colum; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
        //删除列
        for (int i = 0; i < colum; i++) {
            if (C[i] == 1) {
                for (int k = 0; k < row; k++) {
                    matrix[k][i] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {

            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        // 检查第一行是否有0，找到第一个即可
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                rowFlag = true;
                break;
            }
        }
        // 检查第一列是否有0，找到第一个即可
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                colFlag = true;
                break;
            }
        }
        // 检查1到最后行是否有0，记录在第一行中
        // 检查1到最后列是否有0，记录在第一列中
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 如果第一行或者第一列某个为0，把当前i，j置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0
                        || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行
        if (rowFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        // 处理第一列
        if (colFlag) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }

//    private void clear1Row1Colum(int[][] matrix, int m, int n, int row, int colum) {
//        if (m == row || n == colum) {
//            return;
//        }
//        for (int i = 0; i < row; i++) {
//            if(i == m) {
//                continue;
//            }
//            if (matrix[i][n] == 0) {
//                clear1Row1Colum(matrix, i, n, row, colum);
//            } else {
//                matrix[i][n] = 0;
//            }
//
//        }
//        for (int i = 0 ; i < colum; i++) {
//            if(i == n) {
//                continue;
//            }
//            if (matrix[m][i] == 0) {
//                clear1Row1Colum(matrix, m, i, row, colum);
//            } else {
//                matrix[m][i] = 0;
//            }
//
//        }
//    }
}
