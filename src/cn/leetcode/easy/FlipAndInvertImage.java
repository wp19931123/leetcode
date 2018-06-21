package cn.leetcode.easy;

/**
 * 1 <= A.length = A[0].length <= 20
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int[][] res = new int[row][row];
        for(int i = 0;i < row;i++) {
            for(int j = row-1;j >= 0;j--) {
                res[i][row-j-1] = A[i][j]^1;
            }
        }
        return res;
    }
}
