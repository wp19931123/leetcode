package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralOrder().spiralOrder(matrix));  //[1,2,3,4,8,12,11,10,9,5,6,7]

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int row = matrix.length;
        if(row == 0) {
            return res;
        }
        int colum = matrix[0].length;
        if(row == 0 || colum == 0) {
            return res;
        }
        int n = 0;  //打印第几圈
        while (row > 2 * n && colum > 2 * n) {
            printCircle(matrix, row, colum, n++, res);
        }
        return res;
    }

    //打印一圈的函数  第n圈
    public List<Integer> printCircle(int[][] matrix, int row, int colum, int n, List<Integer> list) {
        for (int i = n; i < colum - n; i++) {
            list.add(matrix[n][i]);
        }
        //剩余最少2行
        if (row - 2 * n > 1) {
            for (int i = n + 1; i < row - n; i++) {
                list.add(matrix[i][colum - n - 1]);
            }
        }
        //剩余最少2行2列
        if (row - 2 * n > 1 && colum - 2 * n > 1) {
            for (int i = colum - n - 2; i >= n; i--) {
                list.add(matrix[row - n - 1][i]);
            }
        }
        //剩余至少3行2列
        if (row - 2 * n > 2 && colum - 2 * n > 1) {
            for (int i = row - n - 2; i >= n + 1; i--) {
                list.add(matrix[i][n]);
            }
        }

        return list;
    }
}
