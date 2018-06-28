package cn.leetcode.middle;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *示例:
 * 输入: 3
 * 输出:
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new GenerateMatrix().generateMatrix(3);
        for(int[] arr : matrix) {
            for(int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n <= 0) {
            return res;
        }
        int circle = 0;

        f f = new f();
        while(circle <= Math.ceil(n/2)) {
            generateCircle(res,n,circle++,f);
        }


        return res;
    }
    class f {
        int n;
        f() {
            n = 1;
        }
    }

    //一圈的函数  第n圈
    public int[][] generateCircle(int[][] matrix, int row, int n, f begin) {
        for (int i = n; i < row - n; i++) {
            matrix[n][i] = begin.n++;
        }
        //剩余最少2行
        if (row - 2 * n > 1) {
            for (int i = n + 1; i < row - n; i++) {
                matrix[i][row - n - 1] = begin.n++;
            }
        }
        //剩余最少2行2列
        if (row - 2 * n > 1 && row - 2 * n > 1) {
            for (int i = row - n - 2; i >= n; i--) {
                matrix[row - n - 1][i] = begin.n++;
            }
        }
        //剩余至少3行2列
        if (row - 2 * n > 2 && row - 2 * n > 1) {
            for (int i = row - n - 2; i >= n + 1; i--) {
                matrix[i][n] = begin.n++;
            }
        }
        return matrix;
    }
}
